package garanito.com.br.demoqrcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_videos.*

class VideosActivity :  YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener  {

    private var youTubePlayer: YouTubePlayer? = null
    override fun onInitializationSuccess(
            provider: YouTubePlayer.Provider,
            player: YouTubePlayer,
            wasRestored: Boolean) {
        if (!wasRestored) {
            youTubePlayer = player
            youTubePlayer?.setFullscreen(true)
            youTubePlayer?.setShowFullscreenButton(false)
            player.cueVideo(intent.getStringExtra("v=NfDNrFcVsFc")); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            //player.loadVideo("https://www.youtube.com/watch?v=fhWaJi1Hsfo")
        }
    }
    override fun onInitializationFailure(provider: YouTubePlayer.Provider, errorReason: YouTubeInitializationResult) {
        val error = String.format("Erro", errorReason.toString())
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)
        ytVideo.initialize("AIzaSyAXYjrZ07KimSECrqUFEMild8DOPy95NiQ", this)

    }
}
