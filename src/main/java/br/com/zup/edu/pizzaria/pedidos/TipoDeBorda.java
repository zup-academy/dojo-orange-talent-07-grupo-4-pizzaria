package br.com.zup.edu.pizzaria.pedidos;

import java.math.BigDecimal;

public enum TipoDeBorda {

    TRADICIONAL {

        @Override
        public BigDecimal getPreco() {
            return BigDecimal.ZERO;
        }

    },

    RECHEADA_CATUPIRY {
        @Override
        public BigDecimal getPreco() {
            return new BigDecimal("5.0");
        }
    },

    RECHEADA_CHEDDAR {
        @Override
        public BigDecimal getPreco() {
            return new BigDecimal("5.5");
        }
    };

    public abstract BigDecimal getPreco();

}
