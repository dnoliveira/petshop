package br.com.douglas.petshop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class OrdemServicoId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idOrdem;
    private Long idServico;

}
