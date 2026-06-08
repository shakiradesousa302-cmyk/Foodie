package foodie;
public class Musica {
    public static void Musica() {
    	
    	//aqui esta el sonido del juego, es el codigo de la musica, sonara al ejecutarse
        try {
            javax.sound.midi.Sequencer sequencer = 
                javax.sound.midi.MidiSystem.getSequencer();
            sequencer.open();
            
            javax.sound.midi.Sequence sequence = 
                new javax.sound.midi.Sequence(javax.sound.midi.Sequence.PPQ, 4);
            javax.sound.midi.Track track = sequence.createTrack();
            
            int[] notas = {72, 74, 76, 72, 76, 79, 77, 76, 74, 72, 74, 76, 67, 69, 71, 72};
            
            for (int i = 0; i < notas.length; i++) {
                track.add(new javax.sound.midi.MidiEvent(
                    new javax.sound.midi.ShortMessage(
                        javax.sound.midi.ShortMessage.NOTE_ON, 0, notas[i], 93), i * 4));
                track.add(new javax.sound.midi.MidiEvent(
                    new javax.sound.midi.ShortMessage(
                        javax.sound.midi.ShortMessage.NOTE_OFF, 0, notas[i], 0), i * 4 + 3));
            }
            
            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(140);
            sequencer.setLoopCount(javax.sound.midi.Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            
        } catch (Exception e) {}
}
}
