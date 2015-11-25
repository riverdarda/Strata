/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.integration;

import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.collect.tuple.Pair;
import com.opengamma.strata.math.impl.function.DoubleFunction1D;
import com.opengamma.strata.math.impl.function.special.LegendrePolynomialFunction;
import com.opengamma.strata.math.impl.rootfinding.NewtonRaphsonSingleRootFinder;

/**
 * Class that generates weights and abscissas for Gauss-Legendre quadrature.
 * The weights $w_i$ are given by:
 * $$
 * \begin{align*}
 * w_i = \frac{2}{(1 - x_i^2) L_i'(x_i)^2}
 * \end{align*}
 * $$
 * where $x_i$ is the $i^{th}$ root of the orthogonal polynomial and $L_i'$ is
 * the first derivative of the $i^{th}$ polynomial. The orthogonal polynomial
 * is generated by
 * {@link LegendrePolynomialFunction}.
 */
public class GaussLegendreWeightAndAbscissaFunction implements QuadratureWeightAndAbscissaFunction {

  private static final LegendrePolynomialFunction LEGENDRE = new LegendrePolynomialFunction();
  private static final NewtonRaphsonSingleRootFinder ROOT_FINDER = new NewtonRaphsonSingleRootFinder(1e-15);

  /**
   * {@inheritDoc}
   */
  @Override
  public GaussianQuadratureData generate(int n) {
    ArgChecker.isTrue(n > 0);
    int mid = (n + 1) / 2;
    double[] x = new double[n];
    double[] w = new double[n];
    Pair<DoubleFunction1D, DoubleFunction1D>[] polynomials = LEGENDRE.getPolynomialsAndFirstDerivative(n);
    Pair<DoubleFunction1D, DoubleFunction1D> pair = polynomials[n];
    DoubleFunction1D function = pair.getFirst();
    DoubleFunction1D derivative = pair.getSecond();
    for (int i = 0; i < mid; i++) {
      double root = ROOT_FINDER.getRoot(function, derivative, getInitialRootGuess(i, n));
      x[i] = -root;
      x[n - i - 1] = root;
      double dp = derivative.apply(root);
      w[i] = 2 / ((1 - root * root) * dp * dp);
      w[n - i - 1] = w[i];
    }
    return new GaussianQuadratureData(x, w);
  }

  private double getInitialRootGuess(int i, int n) {
    return Math.cos(Math.PI * (i + 0.75) / (n + 0.5));
  }

}
