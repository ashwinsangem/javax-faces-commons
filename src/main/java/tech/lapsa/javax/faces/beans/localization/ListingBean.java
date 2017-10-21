package tech.lapsa.javax.faces.beans.localization;

import tech.lapsa.java.commons.localization.Localized;

public interface ListingBean<T extends Localized> {

    T[] getAll();

    T[] getSelectable();

    T[] getNonSelectable();

}
