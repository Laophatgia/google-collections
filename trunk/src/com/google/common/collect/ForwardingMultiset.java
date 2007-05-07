// Copyright 2005 Google Inc. All Rights Reserved.

package com.google.common.collect;

import java.util.Set;

/**
 * A multiset which forwards all its method calls to another multiset.
 * Subclasses should override one or more methods to change or add behavior of
 * the backing multiset as desired per the <a
 * href="http://en.wikipedia.org/wiki/Decorator_pattern">decorator pattern</a>.
 *
 * @see ForwardingObject
 * @author kevinb@google.com (Kevin Bourrillion)
 */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E>
    implements Multiset<E> {

  protected ForwardingMultiset(Multiset<E> delegate) {
    super(delegate);
  }

  @SuppressWarnings("unchecked")
  @Override protected Multiset<E> delegate() {
    return (Multiset<E>) super.delegate();
  }

  public int count(Object element) {
    return delegate().count(element);
  }

  public boolean add(E element, int occurrences) {
    return delegate().add(element, occurrences);
  }

  public int remove(Object element, int occurrences) {
    return delegate().remove(element, occurrences);
  }

  public int removeAllOccurrences(Object element) {
    return delegate().removeAllOccurrences(element);
  }

  public Set<E> elementSet() {
    return delegate().elementSet();
  }

  public Set<Entry<E>> entrySet() {
    return delegate().entrySet();
  }

  @Override public boolean equals(Object obj) {
    return delegate().equals(obj);
  }

  @Override public int hashCode() {
    return delegate().hashCode();
  }
}