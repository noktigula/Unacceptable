package ru.nstudio.unacceptable.app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener
{
	private Button m_unacceptable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
		
		m_unacceptable = (Button)findViewById( R.id.buttonLemon );
		m_unacceptable.setOnClickListener( this );
    }

	@Override
	public void onClick( View view )
	{
		switch(view.getId())
		{
			case R.id.buttonLemon:
			{
				playUnacceptable();
				break;
			}
			default:
			{
				throw new IllegalArgumentException( "Unexpected button id" );
			}
		}
	}

	private void playUnacceptable()
	{
		MediaPlayer player = MediaPlayer.create( this,  R.raw.lemon_grab_unacceptable);
		player.setOnCompletionListener( new MediaPlayer.OnCompletionListener()
		{
			@Override
			public void onCompletion( MediaPlayer mediaPlayer )
			{
				mediaPlayer.stop();
				mediaPlayer.release();
			}
		} );

		player.start();
	}
}
