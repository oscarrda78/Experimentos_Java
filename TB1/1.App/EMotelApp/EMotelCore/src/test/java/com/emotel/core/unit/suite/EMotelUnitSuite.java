package com.emotel.core.unit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.emotel.core.unit.test.HotelTest;
import com.emotel.core.unit.test.ReservaHotelTest;
import com.emotel.core.unit.test.ReservaRestauranteTest;
import com.emotel.core.unit.test.RestauranteTest;
import com.emotel.core.unit.test.TipoHotelTest;
import com.emotel.core.unit.test.UsuarioTest;

@RunWith(Categories.class)
@IncludeCategory(PruebasUnitariasTest.class)
@SuiteClasses( { TipoHotelTest.class, HotelTest.class, RestauranteTest.class,
	ReservaHotelTest.class, ReservaRestauranteTest.class, UsuarioTest.class})
public class EMotelUnitSuite {
	
}
