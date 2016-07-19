/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * <p>
 * Please see distribution for license.
 */
package com.opengamma.strata.market.key.scenario;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.market.FieldName;
import com.opengamma.strata.basics.market.MarketDataBox;
import com.opengamma.strata.basics.market.ScenarioMarketDataKey;
import com.opengamma.strata.basics.market.StandardId;
import com.opengamma.strata.collect.array.DoubleArray;
import com.opengamma.strata.market.key.QuoteKey;
import com.opengamma.strata.market.value.scenario.QuotesArray;

/**
 * A key identifying a {@link QuotesArray} containing values for a piece of quoted market data in multiple scenarios.
 */
@BeanDefinition(builderScope = "private")
public final class QuotesArrayKey
    implements ScenarioMarketDataKey<Double, QuotesArray>, ImmutableBean {

  /** The market data key identifying the quote. */
  @PropertyDefinition(validate = "notNull")
  private final QuoteKey key;

  /**
   * Returns a key identifying the market data with the specified ID and field name.
   *
   * @param id  the ID of the quote
   * @param fieldName  the field name of the market data record containing the quote data
   * @return a key identifying the market data with the specified ID and field name
   */
  public static QuotesArrayKey of(StandardId id, FieldName fieldName) {
    return new QuotesArrayKey(QuoteKey.of(id, fieldName));
  }

  /**
   * Returns a key identifying the same market data as the quote key.
   *
   * @param quoteKey  key identifying the quote
   * @return a key identifying the same market data as the quote key
   */
  public static QuotesArrayKey of(QuoteKey quoteKey) {
    return new QuotesArrayKey(quoteKey);
  }

  @Override
  public QuoteKey getMarketDataKey() {
    return key;
  }

  @Override
  public Class<QuotesArray> getScenarioMarketDataType() {
    return QuotesArray.class;
  }

  @Override
  public QuotesArray createScenarioValue(MarketDataBox<Double> marketDataBox, int scenarioCount) {
    return QuotesArray.of(DoubleArray.of(scenarioCount, i -> marketDataBox.getValue(i)));
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code QuotesArrayKey}.
   * @return the meta-bean, not null
   */
  public static QuotesArrayKey.Meta meta() {
    return QuotesArrayKey.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(QuotesArrayKey.Meta.INSTANCE);
  }

  private QuotesArrayKey(
      QuoteKey key) {
    JodaBeanUtils.notNull(key, "key");
    this.key = key;
  }

  @Override
  public QuotesArrayKey.Meta metaBean() {
    return QuotesArrayKey.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the market data key identifying the quote.
   * @return the value of the property, not null
   */
  public QuoteKey getKey() {
    return key;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      QuotesArrayKey other = (QuotesArrayKey) obj;
      return JodaBeanUtils.equal(key, other.key);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(key);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("QuotesArrayKey{");
    buf.append("key").append('=').append(JodaBeanUtils.toString(key));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code QuotesArrayKey}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code key} property.
     */
    private final MetaProperty<QuoteKey> key = DirectMetaProperty.ofImmutable(
        this, "key", QuotesArrayKey.class, QuoteKey.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "key");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 106079:  // key
          return key;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends QuotesArrayKey> builder() {
      return new QuotesArrayKey.Builder();
    }

    @Override
    public Class<? extends QuotesArrayKey> beanType() {
      return QuotesArrayKey.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code key} property.
     * @return the meta-property, not null
     */
    public MetaProperty<QuoteKey> key() {
      return key;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 106079:  // key
          return ((QuotesArrayKey) bean).getKey();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code QuotesArrayKey}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<QuotesArrayKey> {

    private QuoteKey key;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 106079:  // key
          return key;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 106079:  // key
          this.key = (QuoteKey) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public QuotesArrayKey build() {
      return new QuotesArrayKey(
          key);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("QuotesArrayKey.Builder{");
      buf.append("key").append('=').append(JodaBeanUtils.toString(key));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}