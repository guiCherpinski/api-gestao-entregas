package br.com.ctw.api_gestao_entregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Table(name = "tb_motorista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotoristaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "nome",
            nullable = false
    )
    private String nome;

    @Column(
            name = "cnh",
            nullable = false,
            unique = true
    )
    private String cnh;

    @OneToMany(mappedBy = "motorista")
    private Set<EntregaEntity> entrega = new HashSet<>();
}
