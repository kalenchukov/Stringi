/*
 * Copyright © 2022-2023 Алексей Каленчуков
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

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Stringi}.
 *
 * @author Алексей Каленчуков
 */
public class StringiTest
{
	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)}.
	 */
	@Test
	public void testFirstToLowerCase()
	{
		assertEquals("пРИВЕТ", Stringi.firstToLowerCase("ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void testFirstToLowerCaseEmpty()
	{
		assertEquals("", Stringi.firstToLowerCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с одной буквой в значении.
	 */
	@Test
	public void testFirstToLowerCaseOneChar()
	{
		assertEquals("п", Stringi.firstToLowerCase("П"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void testFirstToLowerCaseFirstNotChar()
	{
		assertEquals("_ПРИВЕТ", Stringi.firstToLowerCase("_ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)}.
	 */
	@Test
	public void testFirstToUpperCase()
	{
		assertEquals("Привет", Stringi.firstToUpperCase("привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void testFirstToUpperCaseEmpty()
	{
		assertEquals("", Stringi.firstToUpperCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с одной буквой в значении.
	 */
	@Test
	public void testFirstToUpperCaseOneChar()
	{
		assertEquals("П", Stringi.firstToUpperCase("п"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void testFirstToUpperCaseFirstNotChar()
	{
		assertEquals("_привет", Stringi.firstToUpperCase("_привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}.
	 */
	@Test
	public void testFirstLetterToUpperCase()
	{
		assertEquals("Привет", Stringi.firstLetterToUpperCase("привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void testFirstLetterToUpperCaseEmpty()
	{
		assertEquals("", Stringi.firstLetterToUpperCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}с одной буквой в значении.
	 */
	@Test
	public void testFirstLetterToUpperCaseOneChar()
	{
		assertEquals("П", Stringi.firstLetterToUpperCase("п"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void testFirstLetterToUpperCaseFirstNotChar()
	{
		assertEquals("_-Привет", Stringi.firstLetterToUpperCase("_-привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если в значении нет букв.
	 */
	@Test
	public void testFirstLetterToUpperCaseNotChar()
	{
		assertEquals("_-/*-/-/*", Stringi.firstLetterToUpperCase("_-/*-/-/*"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}.
	 */
	@Test
	public void testFirstLetterToLowerCase()
	{
		assertEquals("пРИВЕТ", Stringi.firstLetterToLowerCase("ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void testFirstLetterToLowerCaseEmpty()
	{
		assertEquals("", Stringi.firstLetterToLowerCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}с одной буквой в значении.
	 */
	@Test
	public void testFirstLetterToLowerCaseOneChar()
	{
		assertEquals("п", Stringi.firstLetterToLowerCase("П"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void testFirstLetterToLowerCaseFirstNotChar()
	{
		assertEquals("_-пРИВЕТ", Stringi.firstLetterToLowerCase("_-ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если в значении нет букв.
	 */
	@Test
	public void testFirstLetterToLowerCaseNotChar()
	{
		assertEquals("_-/*-/-/*", Stringi.firstLetterToLowerCase("_-/*-/-/*"));
	}

	/**
	 * Проверка метода {@link Stringi#reverseCase(String)}.
	 */
	@Test
	public void testReverseCase()
	{
		assertEquals("ПрИвЕт", Stringi.reverseCase("пРиВеТ"));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, Character)}.
	 */
	@Test
	public void testSearchFirst()
	{
		Integer result = Stringi.searchFirst("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(6, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, Character)}.
	 */
	@Test
	public void testSearchLast()
	{
		Integer result = Stringi.searchLast("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(18, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)}.
	 */
	@Test
	public void testSearchFirstList()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));

		assertEquals(46, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с пустым списком.
	 */
	@Test
	public void testSearchFirstListEmpty()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of());

		assertNull(result);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void testSearchFirstListFirstLetter()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));

		assertEquals(0, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void testSearchFirstListManyLetter()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));

		assertEquals(4, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)}.
	 */
	@Test
	public void testSearchLastList()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));

		assertEquals(46, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с пустым списком.
	 */
	@Test
	public void testSearchLastListEmpty()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of());

		assertNull(result);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void testSearchLastListFirstLetter()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));

		assertEquals(0, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void testSearchLastListManyLetter()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));

		assertEquals(15, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirstLetter(String)}.
	 */
	@Test
	public void testSearchFirstLetter()
	{
		Integer result = Stringi.searchFirstLetter("+Когда твоя девушка больна+");

		assertEquals(1, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLastLetter(String)}.
	 */
	@Test
	public void testSearchLastLetter()
	{
		Integer result = Stringi.searchLastLetter("###Ночь###");

		assertEquals(6, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)}.
	 */
	@Test
	public void testRepeatToLength()
	{
		String result = Stringi.repeatToLength("Без десяти", 15);

		assertEquals("Без десятиБез д", result);
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с отрицательным значением.
	 */
	@Test
	public void testRepeatToLengthLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.repeatToLength("Без десяти", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с нулевым значением.
	 */
	@Test
	public void testRepeatToLengthLengthZero()
	{
		String result = Stringi.repeatToLength("Без десяти", 0);

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)}.
	 */
	@Test
	public void testShuffle()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertNotEquals(string, result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} с пустым значением.
	 */
	@Test
	public void testShuffleEmpty()
	{
		String string = "";
		String result = Stringi.shuffle(string);

		assertEquals(string, result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} по количеству символов в строке после перемешивания символов в строке.
	 */
	@Test
	public void testShuffleEqualsLength()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertEquals(string.length(), result.length());
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)}.
	 */
	@Test
	public void testReverse()
	{
		String string = "Малыш";
		String result = Stringi.reverse(string);

		assertEquals("шылаМ", result);
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)} с пустым значением.
	 */
	@Test
	public void testReverseEmpty()
	{
		String string = "";
		String result = Stringi.reverse(string);

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void testCountVariousSymbolsEmpty()
	{
		String string = "";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(0, result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void testCountVariousSymbols()
	{
		String string = "Я хочу быть кочегаром";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(16, result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с переносом строки.
	 */
	@Test
	public void testCountVariousSymbolsReturnLine()
	{
		String string = "Я хочу быть кочегаром\n";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(17, result);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)}.
	 */
	@Test
	public void testIsPalindrome()
	{
		assertTrue(Stringi.isPalindrome("ШАЛАШ"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)} с некорректным значением.
	 */
	@Test
	public void testIsPalindromeNotCorrect()
	{
		assertFalse(Stringi.isPalindrome("МАЛЫШ"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)}.
	 */
	@Test
	public void testIsPalindromeIgnoreCase()
	{
		assertTrue(Stringi.isPalindromeIgnoreCase("Шалаш"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)} с некорректным значением.
	 */
	@Test
	public void testIsPalindromeIgnoreCaseNotCorrect()
	{
		assertFalse(Stringi.isPalindromeIgnoreCase("Малыш"));
	}

	/**
	 * Проверка метода {@link Stringi#join(List)}.
	 */
	@Test
	public void testJoinList()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"));

		assertEquals("Белый день", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(List, String)}.
	 */
	@Test
	public void testJoinListSeparator()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"), "|");

		assertEquals("Белы|й д|ень", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} со значением {@code null}.
	 */
	@Test
	public void testJoinListNull()
	{
		List<String> values = new ArrayList<>();
		values.add("Белый");
		values.add(null);
		values.add("день");

		String result = Stringi.join(values);

		assertEquals("Белыйдень", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} без значений.
	 */
	@Test
	public void testJoinListEmpty()
	{
		String result = Stringi.join(List.of());

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])}.
	 */
	@Test
	public void testJoinArray()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"});

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[], String)}.
	 */
	@Test
	public void testJoinArraySeparator()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"}, "|");

		assertEquals("К|И|Н|О", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} со значением {@code null}.
	 */
	@Test
	public void testJoinArrayNull()
	{
		String result = Stringi.join(new String[] {"K", "I", null, "N", "O"});

		assertEquals("KINO", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} без значений.
	 */
	@Test
	public void testJoinArrayEmpty()
	{
		String result = Stringi.join(new String[] {});

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)}.
	 */
	@Test
	public void testFillLeft()
	{
		String result = Stringi.fillLeft("КИНО", "#", 10);

		assertEquals("######КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void testFillLeftLengthZero()
	{
		String result = Stringi.fillLeft("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillLeftFillerEmpty()
	{
		String result = Stringi.fillLeft("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillLeftStringEmpty()
	{
		String result = Stringi.fillLeft("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void testFillLeftLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillLeft("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)}.
	 */
	@Test
	public void testFill()
	{
		String result = Stringi.fill("КИНО", "#", 10);

		assertEquals("###КИНО###", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} нулевым значением.
	 */
	@Test
	public void testFillLengthZero()
	{
		String result = Stringi.fill("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillFillerEmpty()
	{
		String result = Stringi.fill("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillStringEmpty()
	{
		String result = Stringi.fill("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void testFillLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fill("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с нечётным значением.
	 */
	@Test
	public void testFillLengthUneven()
	{
		String result = Stringi.fill("КИНО", "#", 9);

		assertEquals("##КИНО###", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)}.
	 */
	@Test
	public void testFillRight()
	{
		String result = Stringi.fillRight("КИНО", "#", 10);

		assertEquals("КИНО######", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void testFillRightLengthZero()
	{
		String result = Stringi.fillRight("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillRightFillerEmpty()
	{
		String result = Stringi.fillRight("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void testFillRightStringEmpty()
	{
		String result = Stringi.fillRight("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void testFillRightLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillRight("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
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
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void testToCharListEmpty()
	{
		List<Character> symbols = List.of();

		assertEquals(symbols, Stringi.toCharList(""));
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)}.
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
	 * Проверка метода {@link Stringi#toCharArray(String)} с пустым значением.
	 */
	@Test
	public void testToCharArrayEmpty()
	{
		Character[] symbols = {};

		assertArrayEquals(symbols, Stringi.toCharArray(""));
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)}.
	 */
	@Test
	public void testGlueList()
	{
		String result = Stringi.glue(List.of('A', 'C', '/', 'D', 'C'));

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List, String)}.
	 */
	@Test
	public void testGlueListSeparator()
	{
		String result = Stringi.glue(List.of('T', 'N', 'T'), ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)} со значением {@code null}.
	 */
	@Test
	public void testGlueListNull()
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
	 * Проверка метода {@link Stringi#glue(List)} без значений.
	 */
	@Test
	public void testGlueListEmpty()
	{
		String result = Stringi.glue(List.of());

		assertEquals("", result);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(Character[])}.
	 */
	@Test
	public void testGlueArray()
	{
		String result = Stringi.glue(new Character[] {'A', 'C', '/', 'D', 'C'});

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[], String)}.
	 */
	@Test
	public void testGlueArraySeparator()
	{
		String result = Stringi.glue(new Character[] {'T', 'N', 'T'}, ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} со значением {@code null}.
	 */
	@Test
	public void testGlueArrayNull()
	{
		String result = Stringi.glue(new Character[] {'T', null, 'N', 'T'});

		assertEquals("TNT", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} без значений.
	 */
	@Test
	public void testGlueArrayEmpty()
	{
		String result = Stringi.glue(new Character[] {});

		assertEquals("", result);
	}
}