package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Classe com validações para retirar espaços, campos vazios validar formatação
 * de data e conversor de datas
 *
 * @author queirooz
 */
public class Validador {

    public static String retirarEspacos(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }

    public static boolean validarVazios(String valor, String nome) {
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo " + nome + " precisa ser preenchido.");
            return false;
        }
        return true;
    }

    public static boolean validarData(String valor, String nomeCampo) {
        if (!valor.matches("^\\d{2}\\/\\d{2}\\/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "O campo " + nomeCampo + " precisa ser preenchido no formato dd/MM/yyyy");
            return false;
        }
        return true;
    }

}
