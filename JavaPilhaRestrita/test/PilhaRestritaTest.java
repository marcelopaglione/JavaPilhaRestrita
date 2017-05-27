/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import pilharestrita.PilhaCheiaException;
import pilharestrita.PilhaRestrita;
import pilharestrita.PilhaVaziaException;

/**
 *
 * @author marcelopaglione
 */
public class PilhaRestritaTest {
    
    public PilhaRestritaTest() {
    }
    
    @Test
    public void testMetodoVazia() throws PilhaCheiaException{
        //new
        PilhaRestrita pilhaRestrita = new PilhaRestrita(4);
        //vazia/true
        assertTrue(pilhaRestrita.vazia());
        //empilhar
        pilhaRestrita.empilhar("s1");
        //vazia/false
        assertFalse(pilhaRestrita.vazia());
        //empilha (x-1)
        for (int i = 0; i < 3; i++) {
            pilhaRestrita.empilhar("s"+(i+2));
        }        
        //vazia/false
        assertFalse(pilhaRestrita.vazia());
    }
    
    @Test
    public void testException() throws PilhaCheiaException{
        //new
        PilhaRestrita pilhaRestrita = new PilhaRestrita(4);
        //desempilha/exception
        try{
            pilhaRestrita.desempilhar();
            fail();
        } catch (PilhaVaziaException ex) {}
        //empilha
        pilhaRestrita.empilhar("s1");
        //empilha(x-1)
        for (int i = 0; i < 3; i++) {
            pilhaRestrita.empilhar("s"+(i+2));
        }
        //empilha excpetion
        try{
            pilhaRestrita.empilhar("s5");
            fail();
        }catch(PilhaCheiaException e){}
    }
    
}
