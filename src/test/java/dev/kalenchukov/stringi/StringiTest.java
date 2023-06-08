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
	public void firstToLowerCase()
	{
		assertEquals("пРИВЕТ", Stringi.firstToLowerCase("ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstToLowerCaseEmpty()
	{
		assertEquals("", Stringi.firstToLowerCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToLowerCaseOneChar()
	{
		assertEquals("п", Stringi.firstToLowerCase("П"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToLowerCaseFirstNotChar()
	{
		assertEquals("_ПРИВЕТ", Stringi.firstToLowerCase("_ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)}.
	 */
	@Test
	public void firstToUpperCase()
	{
		assertEquals("Привет", Stringi.firstToUpperCase("привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstToUpperCaseEmpty()
	{
		assertEquals("", Stringi.firstToUpperCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} с одной буквой в значении.
	 */
	@Test
	public void firstToUpperCaseOneChar()
	{
		assertEquals("П", Stringi.firstToUpperCase("п"));
	}

	/**
	 * Проверка метода {@link Stringi#firstToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstToUpperCaseFirstNotChar()
	{
		assertEquals("_привет", Stringi.firstToUpperCase("_привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}.
	 */
	@Test
	public void firstLetterToUpperCase()
	{
		assertEquals("Привет", Stringi.firstLetterToUpperCase("привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToUpperCaseEmpty()
	{
		assertEquals("", Stringi.firstLetterToUpperCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToUpperCaseOneChar()
	{
		assertEquals("П", Stringi.firstLetterToUpperCase("п"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToUpperCaseFirstNotChar()
	{
		assertEquals("_-Привет", Stringi.firstLetterToUpperCase("_-привет"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToUpperCaseNotChar()
	{
		assertEquals("_-/*-/-/*", Stringi.firstLetterToUpperCase("_-/*-/-/*"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}.
	 */
	@Test
	public void firstLetterToLowerCase()
	{
		assertEquals("пРИВЕТ", Stringi.firstLetterToLowerCase("ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} с пустым значением.
	 */
	@Test
	public void firstLetterToLowerCaseEmpty()
	{
		assertEquals("", Stringi.firstLetterToLowerCase(""));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}с одной буквой в значении.
	 */
	@Test
	public void firstLetterToLowerCaseOneChar()
	{
		assertEquals("п", Stringi.firstLetterToLowerCase("П"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если первый символ значения не буква.
	 */
	@Test
	public void firstLetterToLowerCaseFirstNotChar()
	{
		assertEquals("_-пРИВЕТ", Stringi.firstLetterToLowerCase("_-ПРИВЕТ"));
	}

	/**
	 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если в значении нет букв.
	 */
	@Test
	public void firstLetterToLowerCaseNotChar()
	{
		assertEquals("_-/*-/-/*", Stringi.firstLetterToLowerCase("_-/*-/-/*"));
	}

	/**
	 * Проверка метода {@link Stringi#reverseCase(String)}.
	 */
	@Test
	public void reverseCase()
	{
		assertEquals("ПрИвЕт", Stringi.reverseCase("пРиВеТ"));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, Character)}.
	 */
	@Test
	public void searchFirst()
	{
		Integer result = Stringi.searchFirst("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(6, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, Character)}.
	 */
	@Test
	public void searchLast()
	{
		Integer result = Stringi.searchLast("Красно-жёлтые дни - песня группы Кино", '-');

		assertEquals(18, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)}.
	 */
	@Test
	public void searchFirstList()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));

		assertEquals(46, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с пустым списком.
	 */
	@Test
	public void searchFirstListEmpty()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of());

		assertNull(result);
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchFirstListFirstLetter()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));

		assertEquals(0, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirst(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchFirstListManyLetter()
	{
		Integer result = Stringi.searchFirst("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));

		assertEquals(4, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)}.
	 */
	@Test
	public void searchLastList()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('.'));

		assertEquals(46, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с пустым списком.
	 */
	@Test
	public void searchLastListEmpty()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of());

		assertNull(result);
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с первым искомым символом в строке.
	 */
	@Test
	public void searchLastListFirstLetter()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('М'));

		assertEquals(0, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLast(String, List)} с несколькими искомыми символами.
	 */
	@Test
	public void searchLastListManyLetter()
	{
		Integer result = Stringi.searchLast("Мама, мы все тяжело больны - песня группы Кино.", List.of('ж', ','));

		assertEquals(15, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchFirstLetter(String)}.
	 */
	@Test
	public void searchFirstLetter()
	{
		Integer result = Stringi.searchFirstLetter("+Когда твоя девушка больна+");

		assertEquals(1, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#searchLastLetter(String)}.
	 */
	@Test
	public void searchLastLetter()
	{
		Integer result = Stringi.searchLastLetter("###Ночь###");

		assertEquals(6, Optional.ofNullable(result).orElse(-1));
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)}.
	 */
	@Test
	public void repeatToLength()
	{
		String result = Stringi.repeatToLength("Без десяти", 15);

		assertEquals("Без десятиБез д", result);
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с отрицательным значением.
	 */
	@Test
	public void repeatToLengthLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.repeatToLength("Без десяти", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#repeatToLength(String, Integer)} с нулевым значением.
	 */
	@Test
	public void repeatToLengthLengthZero()
	{
		String result = Stringi.repeatToLength("Без десяти", 0);

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)}.
	 */
	@Test
	public void shuffle()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertNotEquals(string, result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} с пустым значением.
	 */
	@Test
	public void shuffleEmpty()
	{
		String string = "";
		String result = Stringi.shuffle(string);

		assertEquals(string, result);
	}

	/**
	 * Проверка метода {@link Stringi#shuffle(String)} по количеству символов в строке после перемешивания символов в строке.
	 */
	@Test
	public void shuffleEqualsLength()
	{
		String string = "Когда твоя девушка больна";
		String result = Stringi.shuffle(string);

		assertEquals(string.length(), result.length());
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)}.
	 */
	@Test
	public void reverse()
	{
		String string = "Малыш";
		String result = Stringi.reverse(string);

		assertEquals("шылаМ", result);
	}

	/**
	 * Проверка метода {@link Stringi#reverse(String)} с пустым значением.
	 */
	@Test
	public void reverseEmpty()
	{
		String string = "";
		String result = Stringi.reverse(string);

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbolsEmpty()
	{
		String string = "";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(0, result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
	 */
	@Test
	public void countVariousSymbols()
	{
		String string = "Я хочу быть кочегаром";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(16, result);
	}

	/**
	 * Проверка метода {@link Stringi#countVariousSymbols(String)} с переносом строки.
	 */
	@Test
	public void countVariousSymbolsReturnLine()
	{
		String string = "Я хочу быть кочегаром\n";
		Integer result = Stringi.countVariousSymbols(string);

		assertEquals(17, result);
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)}.
	 */
	@Test
	public void isPalindrome()
	{
		assertTrue(Stringi.isPalindrome("ШАЛАШ"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindrome(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeNotCorrect()
	{
		assertFalse(Stringi.isPalindrome("МАЛЫШ"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)}.
	 */
	@Test
	public void isPalindromeIgnoreCase()
	{
		assertTrue(Stringi.isPalindromeIgnoreCase("Шалаш"));
	}

	/**
	 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)} с некорректным значением.
	 */
	@Test
	public void isPalindromeIgnoreCaseNotCorrect()
	{
		assertFalse(Stringi.isPalindromeIgnoreCase("Малыш"));
	}

	/**
	 * Проверка метода {@link Stringi#join(List)}.
	 */
	@Test
	public void joinList()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"));

		assertEquals("Белый день", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(List, String)}.
	 */
	@Test
	public void joinListSeparator()
	{
		String result = Stringi.join(List.of("Белы", "й д", "ень"), "|");

		assertEquals("Белы|й д|ень", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(List)} со значением {@code null}.
	 */
	@Test
	public void joinListNull()
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
	public void joinListEmpty()
	{
		String result = Stringi.join(List.of());

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])}.
	 */
	@Test
	public void joinArray()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"});

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[], String)}.
	 */
	@Test
	public void joinArraySeparator()
	{
		String result = Stringi.join(new String[] {"К", "И", "Н", "О"}, "|");

		assertEquals("К|И|Н|О", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} со значением {@code null}.
	 */
	@Test
	public void joinArrayNull()
	{
		String result = Stringi.join(new String[] {"K", "I", null, "N", "O"});

		assertEquals("KINO", result);
	}

	/**
	 * Проверка метода {@link Stringi#join(String[])} без значений.
	 */
	@Test
	public void joinArrayEmpty()
	{
		String result = Stringi.join(new String[] {});

		assertEquals("", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)}.
	 */
	@Test
	public void fillLeft()
	{
		String result = Stringi.fillLeft("КИНО", "#", 10);

		assertEquals("######КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillLeftLengthZero()
	{
		String result = Stringi.fillLeft("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftFillerEmpty()
	{
		String result = Stringi.fillLeft("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillLeftStringEmpty()
	{
		String result = Stringi.fillLeft("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillLeft(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLeftLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillLeft("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)}.
	 */
	@Test
	public void fill()
	{
		String result = Stringi.fill("КИНО", "#", 10);

		assertEquals("###КИНО###", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} нулевым значением.
	 */
	@Test
	public void fillLengthZero()
	{
		String result = Stringi.fill("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillFillerEmpty()
	{
		String result = Stringi.fill("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillStringEmpty()
	{
		String result = Stringi.fill("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fill("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#fill(String, String, Integer)} с нечётным значением.
	 */
	@Test
	public void fillLengthUneven()
	{
		String result = Stringi.fill("КИНО", "#", 9);

		assertEquals("##КИНО###", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)}.
	 */
	@Test
	public void fillRight()
	{
		String result = Stringi.fillRight("КИНО", "#", 10);

		assertEquals("КИНО######", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с нулевым значением.
	 */
	@Test
	public void fillRightLengthZero()
	{
		String result = Stringi.fillRight("КИНО", "#", 0);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightFillerEmpty()
	{
		String result = Stringi.fillRight("КИНО", "", 10);

		assertEquals("КИНО", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с пустым значением.
	 */
	@Test
	public void fillRightStringEmpty()
	{
		String result = Stringi.fillRight("", "#", 10);

		assertEquals("##########", result);
	}

	/**
	 * Проверка метода {@link Stringi#fillRight(String, String, Integer)} с отрицательным значением.
	 */
	@Test
	public void fillRightLengthNegative()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			Stringi.fillRight("КИНО", "#", -1);
		});
	}

	/**
	 * Проверка метода {@link Stringi#toCharList(String)}.
	 */
	@Test
	public void toCharList()
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
	public void toCharListEmpty()
	{
		List<Character> symbols = List.of();

		assertEquals(symbols, Stringi.toCharList(""));
	}

	/**
	 * Проверка метода {@link Stringi#toCharArray(String)}.
	 */
	@Test
	public void toCharArray()
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
	public void toCharArrayEmpty()
	{
		Character[] symbols = {};

		assertArrayEquals(symbols, Stringi.toCharArray(""));
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)}.
	 */
	@Test
	public void glueList()
	{
		String result = Stringi.glue(List.of('A', 'C', '/', 'D', 'C'));

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List, String)}.
	 */
	@Test
	public void glueListSeparator()
	{
		String result = Stringi.glue(List.of('T', 'N', 'T'), ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(List)} со значением {@code null}.
	 */
	@Test
	public void glueListNull()
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
	public void glueListEmpty()
	{
		String result = Stringi.glue(List.of());

		assertEquals("", result);
	}
	
	/**
	 * Проверка метода {@link Stringi#glue(Character[])}.
	 */
	@Test
	public void glueArray()
	{
		String result = Stringi.glue(new Character[] {'A', 'C', '/', 'D', 'C'});

		assertEquals("AC/DC", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[], String)}.
	 */
	@Test
	public void glueArraySeparator()
	{
		String result = Stringi.glue(new Character[] {'T', 'N', 'T'}, ".");

		assertEquals("T.N.T", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} со значением {@code null}.
	 */
	@Test
	public void glueArrayNull()
	{
		String result = Stringi.glue(new Character[] {'T', null, 'N', 'T'});

		assertEquals("TNT", result);
	}

	/**
	 * Проверка метода {@link Stringi#glue(Character[])} без значений.
	 */
	@Test
	public void glueArrayEmpty()
	{
		String result = Stringi.glue(new Character[] {});

		assertEquals("", result);
	}
}