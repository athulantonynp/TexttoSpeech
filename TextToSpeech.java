package textSpeech;
import java.util.Set; 

import javax.sound.sampled.AudioInputStream; 
 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import marytts.LocalMaryInterface; 
import marytts.MaryInterface; 
import marytts.exceptions.MaryConfigurationException; 
import marytts.exceptions.SynthesisException; 
import marytts.util.data.audio.AudioPlayer; 

public class TextToSpeech {
	private static final Logger logger = LoggerFactory.getLogger(TextToSpeech.class); 
	  
	 private static boolean inited = false; 
	 private static boolean isSilenced = false; 
	 private static MaryInterface marytts = null; 
	  
	 protected TextToSpeech() {} 
	  
	 private static void init() throws MaryConfigurationException { 
	  marytts = new LocalMaryInterface(); 
	  Set<String> voices = marytts.getAvailableVoices(); 
	  marytts.setVoice(voices.iterator().next()); 
	  inited = true; 
	 } 
	  
	 public static void say(String comment) {   
	  if (isSilenced) { 
	   System.out.println(comment); 
	   return; 
	  } 
	   
	  try { 
	   if(!inited) { 
	    init(); 
	   } 
	   
	   if (comment.isEmpty()) return; 
	    
	   AudioInputStream audio = marytts.generateAudio(comment); 
	   AudioPlayer player = new AudioPlayer(audio); 
	   player.start(); 
	  } catch (MaryConfigurationException |  
	    SynthesisException e) { 
	   logger.error("Error sythesizing text to voice", e); 
	  } 
	 } 
	  
	 
	 public static void silence(boolean isSilenced) { 
	  TextToSpeech.isSilenced = isSilenced; 
	 } 
	

}
