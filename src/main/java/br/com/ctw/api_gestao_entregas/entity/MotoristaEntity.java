package br.com.ctw.api_gestao_entregas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_motorista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
