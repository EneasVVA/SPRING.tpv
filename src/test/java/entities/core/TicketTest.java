package entities.core;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TicketTest {

    @Test
    public void testTicketLongTicketState() {
        Ticket ticket = new Ticket(666);
        assertTrue(ticket.getReference().length() > 20);
        
    }
    
    @Test
    public void shouldHasQrReference()
    {
        Ticket ticket = new Ticket(666);
        assertTrue(ticket.getQrReference().length > 0);
    }
    
    @Test
    public void testQrReferenceIsReadable() throws IOException
    {
        Ticket ticket = new Ticket(666);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(ticket.getQrReference()));
		
		assertNotEquals(0, img.getHeight());
		assertNotEquals(0, img.getWidth());

    }
    
}