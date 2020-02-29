/*
 * Descripción: Subject patron observer
 * Fecha: 25/02/2020
 * Versión: 1.0
 */
package logic.observer;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public interface Subject {
    public void attach(Observer obs);
    public void dettach(Observer obs);
    public void notifyObservers();
}
