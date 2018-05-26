package ru.stqa.train.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test(enabled = false)
  public void primeTest0() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void primeTestFast() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void primeNonTest1() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2));
  }

  @Test
  public void primeTestLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
}
