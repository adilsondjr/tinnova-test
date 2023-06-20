package br.com.adilsondjr.tinnova.veiculoservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Veiculo {
        @Id
        @GeneratedValue
        private UUID id;
        @NotBlank
        private String veiculo;
        @NotBlank
        private String marca;
        private Integer ano;
        @NotBlank
        private String descricao;
        private Boolean vendido;
        @CreationTimestamp
        private LocalDateTime created;
        @UpdateTimestamp
        private LocalDateTime updated;

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getVeiculo() {
                return veiculo;
        }

        public void setVeiculo(String veiculo) {
                this.veiculo = veiculo;
        }

        public String getMarca() {
                return marca;
        }

        public void setMarca(String marca) {
                this.marca = marca;
        }

        public Integer getAno() {
                return ano;
        }

        public void setAno(Integer ano) {
                this.ano = ano;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public Boolean getVendido() {
                return vendido;
        }

        public void setVendido(Boolean vendido) {
                this.vendido = vendido;
        }

        public LocalDateTime getCreated() {
                return created;
        }

        public void setCreated(LocalDateTime created) {
                this.created = created;
        }

        public LocalDateTime getUpdated() {
                return updated;
        }

        public void setUpdated(LocalDateTime updated) {
                this.updated = updated;
        }
}
