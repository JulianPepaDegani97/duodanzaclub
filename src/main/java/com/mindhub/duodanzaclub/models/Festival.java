package com.mindhub.duodanzaclub.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private Double precio;
    private Estilos estilo;

    @ElementCollection
    @Column(name="horarios")
    private List<Double> horarios = new ArrayList<>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.EAGER)
    private Set<SalaFestival> salaFestival = new HashSet<>();



    public Festival() {
    }

    public Festival(String nombre, Estilos estilo, Double precio, List<Double> horarios) {


        this.nombre = nombre;
        this.precio = precio;
        this.estilo = estilo;
        this.horarios = horarios;
    }

    @JsonIgnore
    public List<Sala> getSalas() {return  salaFestival.stream().map(salaFestival -> salaFestival.getSala()).collect(toList());}

    public long getId() {return id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public Estilos getEstilo() {return estilo;}
    public void setEstilo(Estilos estilo) {this.estilo = estilo;}

    public List<Double> getHorarios() {return horarios;}
    public void setHorarios(List<Double> horarios) {this.horarios = horarios;}

    public Set<SalaFestival> getSalaFestival() {return salaFestival;}
    public void setSalaFestival(Set<SalaFestival> salaFestival) {this.salaFestival = salaFestival;}

}
