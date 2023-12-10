package com.example.generalstore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ItemCategory {
	Appliances,
	Movies_Music,
	Electronics,
	Cameras,
	Computers_Tablets;

	public static List<String> getItemCategoryList() {
		return Stream.of(ItemCategory.values()).map(ItemCategory::name).collect(Collectors.toList());
	}

	public static String[] getItemCategoryArray() {

		return Arrays.stream(ItemCategory.values()).map(ItemCategory::name).toArray(String[]::new);
	}

	public static ItemCategory getItemCategory(String s) {
		ItemCategory result = null;
		switch (s.toLowerCase()) {
			case "appliances":
				result = ItemCategory.Appliances;
				break;
			case "movies_music":
				result = ItemCategory.Movies_Music;
				break;
			case "electronics":
				result = ItemCategory.Electronics;
				break;
			case "cameras":
				result = ItemCategory.Cameras;
				break;
			case "computers_tablets":
				result = ItemCategory.Computers_Tablets;
				break;
		}
		return result;
	}
}
