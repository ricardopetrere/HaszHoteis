/**
 * Copyright \copyright{} 2012 Hugo Prudente.
 *
 * Permission is granted to copy, distribute and/or modify this document under
 * the terms of the GNU Free Documentation License, Version 1.3 or any later
 * version published by the Free Software Foundation; with no Invariant
 * Sections, no Front-Cover Texts, and no Back-Cover Texts. A copy of the
 * license is included in the section entitled ``GNU Free Documentation
 * License''.
 *
 * É dada permissão para copiar, distribuir e / ou modificar este documento nos
 * termos da GNU Free Documentation License, Versão 1.3 ou qualquer versão
 * posterior publicada pela Free Software Fundação; sem Seções Invariantes,
 * Textos de Capa, e sem Textos de Quarta Capa. Uma cópia da licença é incluída
 * na seção intitulada ``GNU Free Documentation License.''
 */
package util;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
 
@FacesValidator("util.CnpjValidator")
public class CnpjValidator implements Validator{
 
  private static char[] aCnpj;
 
  /**
   * Valida um CNPJ, através de uma string recebida;
   *
   * @param cnpj
   * @return boolean
   */
  public static boolean validaCnpj(String cnpj) {
    cnpj = cnpj.replaceAll(Pattern.compile("\\s").toString(), "");
    cnpj = cnpj.replaceAll(Pattern.compile("\\D").toString(), "");
 
    int soma = 0;
 
    if (cnpj.length() != 14) {
      return false;
    }
 
    aCnpj = cnpj.toCharArray();
 
    soma += (parseCharToInt(aCnpj[0]) * 5);
    soma += (parseCharToInt(aCnpj[1]) * 4);
    soma += (parseCharToInt(aCnpj[2]) * 3);
    soma += (parseCharToInt(aCnpj[3]) * 2);
    soma += (parseCharToInt(aCnpj[4]) * 9);
    soma += (parseCharToInt(aCnpj[5]) * 8);
    soma += (parseCharToInt(aCnpj[6]) * 7);
    soma += (parseCharToInt(aCnpj[7]) * 6);
    soma += (parseCharToInt(aCnpj[8]) * 5);
    soma += (parseCharToInt(aCnpj[9]) * 4);
    soma += (parseCharToInt(aCnpj[10]) * 3);
    soma += (parseCharToInt(aCnpj[11]) * 2);
 
    int d1 = soma % 11;
    d1 = d1 < 2 ? 0 : 11 - d1;
 
    soma = 0;
    soma += (parseCharToInt(aCnpj[0]) * 6);
    soma += (parseCharToInt(aCnpj[1]) * 5);
    soma += (parseCharToInt(aCnpj[2]) * 4);
    soma += (parseCharToInt(aCnpj[3]) * 3);
    soma += (parseCharToInt(aCnpj[4]) * 2);
    soma += (parseCharToInt(aCnpj[5]) * 9);
    soma += (parseCharToInt(aCnpj[6]) * 8);
    soma += (parseCharToInt(aCnpj[7]) * 7);
    soma += (parseCharToInt(aCnpj[8]) * 6);
    soma += (parseCharToInt(aCnpj[9]) * 5);
    soma += (parseCharToInt(aCnpj[10]) * 4);
    soma += (parseCharToInt(aCnpj[11]) * 3);
    soma += (parseCharToInt(aCnpj[12]) * 2);
 
 
    int d2 = soma % 11;
    d2 = d2 < 2 ? 0 : 11 - d2;
 
    if (parseCharToInt(aCnpj[12]) == d1 && parseCharToInt(aCnpj[13]) == d2) {
      return true;
    } else {
      return false;
    }
  }
 
  private static final String CPF_PATTERN = "^[0-9]{4}\\.[0-9]\\.[0-9]{3}\\[0-9]{3}-[0-9]{2}#";

    private Pattern pattern;
    private Matcher matcher;

    public CnpjValidator() {
        pattern = Pattern.compile(CPF_PATTERN);
    }
  
  private static int parseCharToInt(char c) {
    return Integer.parseInt(Character.toString(c));
  }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (value.toString().replace("_", "").length() != 14) {
            FacesMessage msg = new FacesMessage("Preencha por completo o CNPJ.", "Formato inválido de 678678.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (!validaCnpj(value.toString())) {
            FacesMessage msg = new FacesMessage("Falhou a validação de CNPJ.", "Formato inválido de 67867868.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }/* else {
            FacesMessage msg = new FacesMessage("Sucesso na validação de CPF.", "CPF válido.");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(msg);
        }*/
    }
}