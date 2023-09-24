package it.cudia.studio.android.pokedroid.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.MainActivity;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseInstanceIDSer";
    private static final int NOTIFICATION_ID = 1005;
    private static final String CHANNEL_ID = "CHANNEL_FRIENDSHIP";

    @Override
    public void onNewToken(String mToken) {
        super.onNewToken(mToken);
        Log.e("TOKEN", mToken);
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fb", mToken).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived() called with: remoteMessage = [" + remoteMessage.getData().get("score") + "]");

        Intent mainIntent = new Intent(this, MainActivity.class);

        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent mainPIntent = PendingIntent.getActivity(this, 0, mainIntent,  PendingIntent.FLAG_MUTABLE  | PendingIntent.FLAG_UPDATE_CURRENT );

        Intent acceptFriendshipIntent = new Intent(this, MainActivity.class);

        acceptFriendshipIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        acceptFriendshipIntent.putExtra("methodName","acceptFriend");
        acceptFriendshipIntent.putExtra("usernameMandante",remoteMessage.getData().get("username"));
        acceptFriendshipIntent.putExtra("tokenMandante",remoteMessage.getData().get("token"));
        PendingIntent acceptFriendshipPIntent = PendingIntent.getActivity(this, 1, acceptFriendshipIntent,  PendingIntent.FLAG_MUTABLE  | PendingIntent.FLAG_UPDATE_CURRENT );

        Intent discardFriendshipIntent = new Intent(this, MainActivity.class);

        discardFriendshipIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        discardFriendshipIntent.putExtra("methodName","discardFriend");
        discardFriendshipIntent.putExtra("usernameMandante",remoteMessage.getData().get("username"));
        discardFriendshipIntent.putExtra("tokenMandante",remoteMessage.getData().get("token"));
        PendingIntent discardFriendshipPIntent = PendingIntent.getActivity(this, 2, discardFriendshipIntent,  PendingIntent.FLAG_MUTABLE  | PendingIntent.FLAG_UPDATE_CURRENT );
        //

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.pika_icon)
                .setContentTitle("Richiesta di amicizia")
                .setContentText("Richiesta di amicizia da parte di "+remoteMessage.getData().get("username"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).
                setShowWhen(true)
                .setAutoCancel(true)
                .setContentIntent(mainPIntent)
                .addAction(R.drawable.baseline_group_add_24,"Accept friend",acceptFriendshipPIntent)
                .addAction(R.drawable.baseline_do_not_disturb_24,"Discard friend",discardFriendshipPIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d(TAG, "onMessageReceived() no permission");
            return;
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(CHANNEL_ID);
            Log.d(TAG, "onMessageReceived() si si permission");
        }

        notificationManager.notify(NOTIFICATION_ID, builder.build());
        Log.d(TAG, "onMessageReceived() si permission");
    }

    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fb", "empty");
    }

}
