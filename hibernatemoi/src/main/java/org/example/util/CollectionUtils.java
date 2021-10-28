package org.example.util;

import java.util.Collection;

public class CollectionUtils {
	public static boolean isEmty(Collection collection) {
		return !ObjectUtil.isEmpty(collection) && collection.isEmpty();
	}
}
