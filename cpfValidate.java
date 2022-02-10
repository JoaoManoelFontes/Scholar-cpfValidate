import java.util.Scanner;

class cpfValidate {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o cpf:");
    String cpf = sc.next();
    if (validate(cpf)) {
      System.out.println("Cpf Válido!");
    } else {
      System.out.println("Cpf Inválido!");
    }
  }

  public static boolean validate(String cpf) {
    String validateNumbers = cpf.replace(".", "").replace("-", "");
    if (!isDouble(validateNumbers)) {
      System.out.println(
        "Erro! Digite apenas números e os caractéres '.' e '-' "
      );
      return false;
    } else if (cpf.length() != 14) {
      if (validateNumbers.length() < 11) {
        System.out.println("Erro! Falta(m) algum(s) número(s)");
      } else if (validateNumbers.length() > 11) {
        System.out.println("Erro! Tem mais que 11 números");
      } else {
        validateChars(cpf);
      }
      return false;
    } else if (
      !validateDigit(validateNumbers) || !validateSameNumbers(validateNumbers)
    ) {
      System.out.println("O cpf não existe!");
      return false;
    } else {
      return true;
    }
  }

  public static void validateChars(String cpf) {
    if (cpf.indexOf("-") == -1) {
      System.out.println("Erro! Falta o '-'");
    }
    if (cpf.indexOf(".") == -1) {
      System.out.println("Erro! Faltam os '.'");
    } else if (cpf.indexOf(".", 3) == -1) {
      System.out.println("Erro! Falta o '.'");
    } else if (cpf.indexOf(".", 7) == -1) {
      System.out.println("Erro! Falta o '.'");
    }
  }

  public static boolean validateDigit(String cpf) {
    String newCpf = cpf.substring(0, cpf.length() - 2);
    int multiplyNumbers = 0;
    for (int i = 0; i < newCpf.length(); i++) {
      multiplyNumbers +=
        (Integer.parseInt(newCpf.substring(i, (i + 1))) * (i + 1));
    }

    int firstDigit = (multiplyNumbers % 11);
    if (firstDigit == 10) {
      firstDigit = 0;
    }

    newCpf += Integer.toString(firstDigit);

    multiplyNumbers = 0;
    for (int i = 0; i < newCpf.length(); i++) {
      multiplyNumbers += (Integer.parseInt(newCpf.substring(i, (i + 1))) * (i));
    }
    int secondDigit = (multiplyNumbers % 11);
    if (secondDigit == 10) {
      secondDigit = 0;
    }
    newCpf += Integer.toString(secondDigit);

    if (cpf.equals(newCpf)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean validateSameNumbers(String cpf) {
    int countSameNumbers = 0;
    for (int i = 0; i < cpf.length() - 1; i++) {
      if (cpf.substring(i, (i + 1)).equals(cpf.substring(i + 1, (i + 2)))) {
        countSameNumbers++;
      }
    }
    if (countSameNumbers == 10) {
      return false;
    }

    return true;
  }

  public static boolean isDouble(String str) {
    try {
      Double.parseDouble(str);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
