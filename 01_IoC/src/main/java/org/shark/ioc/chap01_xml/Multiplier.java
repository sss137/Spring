package org.shark.ioc.chap01_xml;

public class Multiplier {

  public int multyply(int... args) {
    if(args == null) {
      return 0;
    }
    int product = 1;
    for(int i = 0; i < args.length; i++) {
      product *= args[i];
    }
    return product;
  }
  
}
