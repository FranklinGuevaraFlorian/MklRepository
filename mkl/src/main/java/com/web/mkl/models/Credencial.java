package com.web.mkl.models;

import com.web.mkl.records.CrearCredencial;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_credenciales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idCredencial")
@ToString
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredencial;
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 16, nullable = false, unique = true)
    private String salt;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Credencial(CrearCredencial datos) {
        this.salt = "sJKIUJKIjkuqhyh1";
        this.email = datos.email();
        this.password = datos.password();
        this.usuario = new Usuario(datos.usuario());
    }
}
