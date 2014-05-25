package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

@FacesValidator("util.CnpjValidator")
public class CnpjValidator implements Validator {

    private static char[] aCnpj;

    private static final String CNPJ_PATTERN = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";

    private Pattern pattern;
    private Matcher matcher;

    public CnpjValidator() {
        pattern = Pattern.compile(CNPJ_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (value.toString().replace("_", "").length() != 18) {
            FacesMessage msg = new FacesMessage("Preencha por completo o CNPJ.", "Formato inválido de CNPJ.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (!validaCnpj(value.toString())) {
            FacesMessage msg = new FacesMessage("Falhou a validação de CNPJ.", "Formato inválido de CNPJ.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    private static int parseCharToInt(char c) {
        return Integer.parseInt(Character.toString(c));
    }

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
}