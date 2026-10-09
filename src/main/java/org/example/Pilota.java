package org.example;

// Questa classe rappresenta il tipo di oggetto che vogliamo convertire in JSON e viceversa.
public class Pilota {

    // Attributi dell'oggetto Pilota.
    // Sono public per mantenere questo esempio semplice e permettere a Jackson di leggere e scrivere direttamente i loro valori.
    public String nome;
    public String squadra;
    public int numero;

    // Costruttore vuoto.
    // È utile durante la deserializzazione: Jackson può creare prima un oggetto Pilota vuoto e successivamente assegnare ai suoi attributi i valori letti dal JSON.
    public Pilota() {
    }

    // Costruttore con parametri.
    // Lo utilizziamo quando siamo noi a creare manualmente un oggetto Pilota nel programma.
    public Pilota(String nome, String squadra, int numero) {

        // "this.nome" indica l'attributo dell'oggetto.
        // "nome" indica invece il parametro ricevuto dal costruttore.
        this.nome = nome;
        this.squadra = squadra;
        this.numero = numero;
    }
}