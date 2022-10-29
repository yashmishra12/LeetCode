class Solution {
    private int BILLION = 1000000000;
    private int MILLION = 100000000;
    
  public String oneDigit(int num) {
    switch(num) {
      case 1: return "One";
      case 2: return "Two";
      case 3: return "Three";
      case 4: return "Four";
      case 5: return "Five";
      case 6: return "Six";
      case 7: return "Seven";
      case 8: return "Eight";
      case 9: return "Nine";
    }
    return "";
  }

  public String twoLessThan20(int num) {
    switch(num) {
      case 10: return "Ten";
      case 11: return "Eleven";
      case 12: return "Twelve";
      case 13: return "Thirteen";
      case 14: return "Fourteen";
      case 15: return "Fifteen";
      case 16: return "Sixteen";
      case 17: return "Seventeen";
      case 18: return "Eighteen";
      case 19: return "Nineteen";
    }
    return "";
  }

  public String tens(int num) {
    switch(num) {
      case 2: return "Twenty";
      case 3: return "Thirty";
      case 4: return "Forty";
      case 5: return "Fifty";
      case 6: return "Sixty";
      case 7: return "Seventy";
      case 8: return "Eighty";
      case 9: return "Ninety";
    }
    return "";
  }

  public String twoDigit(int num) {
    if (num == 0){return "";}
    else if (num < 10)
      {return oneDigit(num);}
    else if (num < 20)
      {return twoLessThan20(num);}
    else {
      int tenner = num / 10;
      int rest = num%10;
      if (rest != 0) {return tens(tenner) + " " + oneDigit(rest);}
      else {return tens(tenner);}
    }
  }

  public String threeDigit(int num) {
    int hundred = num / 100;
    int rest = num - (hundred * 100);
    String res = "";
    if (hundred*rest != 0)
      res = oneDigit(hundred) + " Hundred " + twoDigit(rest);
    else if ((hundred == 0) && (rest != 0))
      res = twoDigit(rest);
    else if ((hundred != 0) && (rest == 0))
      res = oneDigit(hundred) + " Hundred";
    return res;
  }

  public String numberToWords(int num) {
    if (num == 0) {return "Zero";}
      
    int billion = num / 1000000000;
    int million = (num - billion * 1000000000) / 1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
    int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

    StringBuilder result = new StringBuilder();
    if (billion != 0){
      result.append(threeDigit(billion) + " Billion");  
    }
      
    if (million != 0) {
      if (!result.isEmpty()) {result.append(" ");}
      result.append(threeDigit(million) + " Million");
    }
    if (thousand != 0) {
      if (!result.isEmpty()) {result.append(" ");}
      result.append(threeDigit(thousand) + " Thousand");
    }
    if (rest != 0) {
      if (!result.isEmpty()) {result.append(" ");}
      result.append(threeDigit(rest));
    }
      
    return result.toString();
  }
}