/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.stringi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringiTest
{
	public static final Character[] SYMBOLS = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
		',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
		'[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
	};

	/**
	 * Проверка преобразования первого символа к строчному.
	 */
	@Test
	public void testFirstToLowerCase()
	{
		assertEquals("", Stringi.firstToLowerCase(""));
		assertEquals("п", Stringi.firstToLowerCase("П"));
		assertEquals("пРИВЕТ", Stringi.firstToLowerCase("ПРИВЕТ"));
		assertEquals("_ПРИВЕТ", Stringi.firstToLowerCase("_ПРИВЕТ"));
	}

	/**
	 * Проверка преобразования первого символа к прописному.
	 */
	@Test
	public void testFirstToUpperCase()
	{
		assertEquals("", Stringi.firstToUpperCase(""));
		assertEquals("П", Stringi.firstToUpperCase("п"));
		assertEquals("Привет", Stringi.firstToUpperCase("привет"));
		assertEquals("_привет", Stringi.firstToUpperCase("_привет"));
	}

	/**
	 * Проверка преобразования регистра первой найденной буквы к прописному.
	 */
	@Test
	public void firstLetterToUpperCase()
	{
		assertEquals("", Stringi.firstLetterToUpperCase(""));
		assertEquals("П", Stringi.firstLetterToUpperCase("п"));
		assertEquals("Привет", Stringi.firstLetterToUpperCase("привет"));
		assertEquals("Ппривет", Stringi.firstLetterToUpperCase("ппривет"));
		assertEquals("_-Привет", Stringi.firstLetterToUpperCase("_-привет"));
		assertEquals("_-/*-/-/*", Stringi.firstLetterToUpperCase("_-/*-/-/*"));
	}

	/**
	 * Проверка преобразования регистра первой найденной буквы к строчному.
	 */
	@Test
	public void firstLetterToLowerCase()
	{
		assertEquals("", Stringi.firstLetterToLowerCase(""));
		assertEquals("п", Stringi.firstLetterToLowerCase("П"));
		assertEquals("пРИВЕТ", Stringi.firstLetterToLowerCase("ПРИВЕТ"));
		assertEquals("пПРИВЕТ", Stringi.firstLetterToLowerCase("ППРИВЕТ"));
		assertEquals("_-пРИВЕТ", Stringi.firstLetterToLowerCase("_-ПРИВЕТ"));
		assertEquals("_-/*-/-/*", Stringi.firstLetterToLowerCase("_-/*-/-/*"));
	}

	/**
	 * Проверка преобразования регистра букв в противоположный.
	 */
	@Test
	public void testReverseCase()
	{
		assertEquals("привет", Stringi.reverseCase("ПРИВЕТ"));
		assertEquals("ПРИВЕТ", Stringi.reverseCase("привет"));
		assertEquals("ПрИвЕт", Stringi.reverseCase("пРиВеТ"));
	}

	/**
	 * Проверка поиска первого вхождения символа в строке.
	 */
	@Test
	public void testSearchFirstSymbol()
	{
		Integer result = Stringi.searchFirst("Красно-жёлтые дни - песня группы Кино", '-');

		assert result != null;

		assertEquals(6, (int) result);
	}

	/**
	 * Проверка поиска последнего вхождения символа в строке.
	 */
	@Test
	public void testSearchLastSymbol()
	{
		Integer result = Stringi.searchLast("Красно-жёлтые дни - песня группы Кино", '-');

		assert result != null;

		assertEquals(18, (int) result);
	}

	/**
	 * Проверка поиска первого вхождения одного из символов в строке.
	 */
	@Test
	public void testSearchFirstSymbols()
	{
		Integer result = null;

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of());
		assertNull(result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));
		assert result != null;
		assertEquals(0, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));
		assert result != null;
		assertEquals(46, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('е'));
		assert result != null;
		assertEquals(11, (int) result);

		result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));
		assert result != null;
		assertEquals(4, (int) result);
	}

	/**
	 * Проверка поиска последнего вхождения одного из символов в строке.
	 */
	@Test
	public void testSearchLastSymbols()
	{
		Integer result = null;

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of());
		assertNull(result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));
		assert result != null;
		assertEquals(0, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));
		assert result != null;
		assertEquals(46, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('е'));
		assert result != null;
		assertEquals(30, (int) result);

		result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));
		assert result != null;
		assertEquals(15, (int) result);
	}

	/**
	 * Проверка поиска первой буквы в строке.
	 */
	@Test
	public void testSearchFirstLetter()
	{
		Integer result = Stringi.searchFirstLetter("+Когда твоя девушка больна+");

		assert result != null;

		assertEquals(1, (int) result);
	}

	/**
	 * Проверка поиска первой буквы в строке.
	 */
	@Test
	public void testSearchLastLetter()
	{
		Integer result = Stringi.searchLastLetter("###Ночь###");

		assert result != null;

		assertEquals(6, (int) result);
	}

	/**
	 * Проверка с корректными параметрами.
	 */
	@Test
	public void testRepeatToLength()
	{
		String result = Stringi.repeatToLength("Без десяти", 15);

		assertEquals("Без десятиБез д", result);
	}

	/**
	 * Проверка с отрицательным количество раз.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRepeatToLengthLengthNegative()
	{
		Stringi.repeatToLength("Без десяти", -1);
	}

	/**
	 * Проверка с параметром {@code length} = 0.
	 */
	@Test
	public void testRepeatToLengthLengthZero()
	{
		String result = Stringi.repeatToLength("Без десяти", 0);

		assertEquals("", result);
	}

	/**
	 * Проверка перемешивания символов в строке.
	 */
	@Test
	public void testShuffle()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertNotEquals(string, result);
	}

	/**
	 * Проверка перемешивания символов в пустой строке.
	 */
	@Test
	public void testShuffleEmpty()
	{
		String string = "";
		String result = Stringi.shuffle(string);

		assertEquals(string, result);
	}

	/**
	 * Проверка равенства по количеству символов в строке после перемешивания символов в строке.
	 */
	@Test
	public void testShuffleEqualsLength()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertEquals(string.length(), result.length());
	}

	/**
	 * Проверка переворачивания строки.
	 */
	@Test
	public void testReverse()
	{
		String string = "Малыш";
		String result = Stringi.reverse(string);

		assertEquals("шылаМ", result);
	}

	/**
	 * Проверка переворачивания пустой строки.
	 */
	@Test
	public void testReverseEmpty()
	{
		String string = "";
		String result = Stringi.reverse(string);

		assertEquals("", result);
	}

	/**
	 * Проверка строки палиндрома.
	 */
	@Test
	public void testIsPalindrome()
	{
		assertTrue("ШАЛАШ", Stringi.isPalindrome("ШАЛАШ"));
		assertFalse("МАЛЫШ", Stringi.isPalindrome("МАЛЫШ"));
	}

	/**
	 * Проверка строки палиндрома без учёта регистра букв.
	 */
	@Test
	public void testIsPalindromeIgnoreCase()
	{
		assertTrue("Шалаш", Stringi.isPalindromeIgnoreCase("Шалаш"));
		assertFalse("Малыш", Stringi.isPalindromeIgnoreCase("Малыш"));
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} в строку.
	 */
	@Test
	public void testJoinListString()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"));

		assertEquals("Белый день", result);
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} в строку с разделителем.
	 */
	@Test
	public void testJoinListStringSeparator()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"), "|");

		assertEquals("Белы|й д|ень", result);
	}

	/**
	 * Проверка объединения элементов коллекции из {@code String} со значением {@code null} в строку.
	 */
	@Test
	public void testJoinListStringNull()
	{
		List<String> values = new ArrayList<>();
		values.add("Белый");
		values.add(null);
		values.add("день");

		String result = Stringi.join(values);

		assertEquals("Белыйдень", result);
	}

	/**
	 * Проверка объединения пустой коллекции из {@code String} в строку.
	 */
	@Test
	public void testJoinListStringEmpty()
	{
		String result = Stringi.join(List.of());

		assertEquals("", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} в строку.
	 */
	@Test
	public void testJoinArrayString()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"});

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} в строку с разделителем.
	 */
	@Test
	public void testJoinArrayStringSeparator()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"}, "|");

		assertEquals("К|И|Н|О", result);
	}

	/**
	 * Проверка объединения элементов массива из {@code String} со значением {@code null} в строку.
	 */
	@Test
	public void testJoinArrayStringNull()
	{
		String result = Stringi.join(new String[] {"K", "I", null, "N", "O"});

		assertEquals("KINO", result);
	}

	/**
	 * Проверка объединения пустого массива из {@code String} в строку.
	 */
	@Test
	public void testJoinArrayStringEmpty()
	{
		String result = Stringi.join(new String[] {});

		assertEquals("", result);
	}

	/**
	 * Проверка с корректными данными.
	 */
	@Test
	public void testFillLeft()
	{
		String result = Stringi.fillLeft("КИНО", "#", 10);

		assertEquals("######КИНО", result);
	}

	/**
	 * Проверка с параметром {@code length} = 0.
	 */
	@Test
	public void testFillLeftLengthZero()
	{
		String result = Stringi.fillLeft("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code filler} = "".
	 */
	@Test
	public void testFillLeftFillerEmpty()
	{
		String result = Stringi.fillLeft("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code string} = "".
	 */
	@Test
	public void testFillLeftStringEmpty()
	{
		String result = Stringi.fillLeft("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка с параметром {@code length} = -1.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFillLeftLengthNegative()
	{
		Stringi.fillLeft("КИНО", "#", -1);
	}

	/**
	 * Проверка с корректными данными.
	 */
	@Test
	public void testFill()
	{
		String result = Stringi.fill("КИНО", "#", 10);

		assertEquals("###КИНО###", result);
	}

	/**
	 * Проверка с параметром {@code length} = 0.
	 */
	@Test
	public void testFillLengthZero()
	{
		String result = Stringi.fill("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code filler} = "".
	 */
	@Test
	public void testFillFillerEmpty()
	{
		String result = Stringi.fill("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code string} = "".
	 */
	@Test
	public void testFillStringEmpty()
	{
		String result = Stringi.fill("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка с параметром {@code length} = -1.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFillLengthNegative()
	{
		Stringi.fill("КИНО", "#", -1);
	}

	/**
	 * Проверка с нечётным параметром {@code length}.
	 */
	@Test
	public void testFillLengthUneven()
	{
		String result = Stringi.fill("КИНО", "#", 9);

		assertEquals("##КИНО###", result);
	}

	/**
	 * Проверка с корректными данными.
	 */
	@Test
	public void testFillRight()
	{
		String result = Stringi.fillRight("КИНО", "#", 10);

		assertEquals("КИНО######", result);
	}

	/**
	 * Проверка с параметром {@code length} = 0.
	 */
	@Test
	public void testFillRightLengthZero()
	{
		String result = Stringi.fillRight("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code filler} = "".
	 */
	@Test
	public void testFillRightFillerEmpty()
	{
		String result = Stringi.fillRight("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка с параметром {@code string} = "".
	 */
	@Test
	public void testFillRightStringEmpty()
	{
		String result = Stringi.fillRight("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка с параметром {@code length} = -1.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFillRightLengthNegative()
	{
		Stringi.fillRight("КИНО", "#", -1);
	}

	/**
	 * Проверка с наличием букв.
	 */
	@Test
	public void testToCharList()
	{
		List<Character> symbols = List.of(
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		);

		assertEquals(symbols, Stringi.toCharList("Walk all over you"));
	}

	/**
	 * Проверка без букв.
	 */
	@Test
	public void testToCharListEmpty()
	{
		List<Character> symbols = List.of();

		assertEquals(symbols, Stringi.toCharList(""));
	}

	/**
	 * Проверка с наличием букв.
	 */
	@Test
	public void testToCharArray()
	{
		Character[] symbols = {
			'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
		};

		assertArrayEquals(symbols, Stringi.toCharArray("Walk all over you"));
	}

	/**
	 * Проверка без букв.
	 */
	@Test
	public void testToCharArrayEmpty()
	{
		Character[] symbols = {};

		assertArrayEquals(symbols, Stringi.toCharArray(""));
	}

	/**
	 * Проверка склеивания элементов коллекции из {@code Character} в строку.
	 */
	@Test
	public void testGlueListString()
	{
		String result = Stringi.glue(List.of('A', 'C', '/', 'D', 'C'));

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка склеивания элементов коллекции из {@code Character} в строку с разделителем.
	 */
	@Test
	public void testGlueListStringSeparator()
	{
		String result = Stringi.glue(List.of('T', 'N', 'T'), ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка склеивания элементов коллекции из {@code Character} со значением {@code null} в строку.
	 */
	@Test
	public void testGlueListStringNull()
	{
		List<Character> values = new ArrayList<>();
		values.add('A');
		values.add('C');
		values.add(null);
		values.add('D');
		values.add('C');

		String result = Stringi.glue(values);

		assertEquals("ACDC", result);
	}

	/**
	 * Проверка склеивания пустой коллекции из {@code Character} в строку.
	 */
	@Test
	public void testGlueListStringEmpty()
	{
		String result = Stringi.glue(List.of());

		assertEquals("", result);
	}

	/**
	 * Проверка склеивания элементов массива из {@code Character} в строку.
	 */
	@Test
	public void testGlueArrayString()
	{
		String result = Stringi.glue(new Character[] {'A', 'C', '/', 'D', 'C'});

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка склеивания элементов массива из {@code Character} в строку с разделителем.
	 */
	@Test
	public void testGlueArrayStringSeparator()
	{
		String result = Stringi.glue(new Character[] {'T', 'N', 'T'}, ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка склеивания элементов массива из {@code Character} со значением {@code null} в строку.
	 */
	@Test
	public void testGlueArrayStringNull()
	{
		String result = Stringi.glue(new Character[] {'T', null, 'N', 'T'});

		assertEquals("TNT", result);
	}

	/**
	 * Проверка склеивания пустого массива из {@code Character} в строку.
	 */
	@Test
	public void testGlueArrayStringEmpty()
	{
		String result = Stringi.glue(new Character[] {});

		assertEquals("", result);
	}
}