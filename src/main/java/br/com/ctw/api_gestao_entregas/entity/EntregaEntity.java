package br.com.ctw.api_gestao_entregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_entrega")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntregaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "descricao",
            nullable = false
    )
    private String descricao;

    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id")
    private MotoristaEntity motorista;
}
