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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Класс проверки методов класса {@link Stringi}.
 *
 * @author Алексей Каленчуков
 */
public class StringiTest
{
	/**
	 * Класс проверки метода {@link Stringi#firstToLowerCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FirstToLowerCase
	{
		/**
		 * Проверка метода {@link Stringi#firstToLowerCase(String)}.
		 */
		@Test
		public void firstToLowerCase()
		{
			String value = "ПРИВЕТ";

			String actualString = Stringi.firstToLowerCase(value);

			assertThat(actualString).isEqualTo("пРИВЕТ");
		}

		/**
		 * Проверка метода {@link Stringi#firstToLowerCase(String)} с пустым значением.
		 */
		@Test
		public void firstToLowerCaseEmpty()
		{
			String value = "";

			String actualString = Stringi.firstToLowerCase(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#firstToLowerCase(String)} с одной буквой в значении.
		 */
		@Test
		public void firstToLowerCaseOneChar()
		{
			String value = "П";

			String actualString = Stringi.firstToLowerCase(value);

			assertThat(actualString).isEqualTo("п");
		}

		/**
		 * Проверка метода {@link Stringi#firstToLowerCase(String)} если первый символ значения не буква.
		 */
		@Test
		public void firstToLowerCaseFirstNotChar()
		{
			String value = "_ПРИВЕТ";

			String actualString = Stringi.firstToLowerCase(value);

			assertThat(actualString).isEqualTo("_ПРИВЕТ");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#firstToUpperCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FirstToUpperCase
	{
		/**
		 * Проверка метода {@link Stringi#firstToUpperCase(String)}.
		 */
		@Test
		public void firstToUpperCase()
		{
			String value = "привет";

			String actualString = Stringi.firstToUpperCase(value);

			assertThat(actualString).isEqualTo("Привет");
		}

		/**
		 * Проверка метода {@link Stringi#firstToUpperCase(String)} с пустым значением.
		 */
		@Test
		public void firstToUpperCaseEmpty()
		{
			String value = "";

			String actualString = Stringi.firstToUpperCase(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#firstToUpperCase(String)} с одной буквой в значении.
		 */
		@Test
		public void firstToUpperCaseOneChar()
		{
			String value = "п";

			String actualString = Stringi.firstToUpperCase(value);

			assertThat(actualString).isEqualTo("П");
		}

		/**
		 * Проверка метода {@link Stringi#firstToUpperCase(String)} если первый символ значения не буква.
		 */
		@Test
		public void firstToUpperCaseFirstNotChar()
		{
			String value = "_привет";

			String actualString = Stringi.firstToUpperCase(value);

			assertThat(actualString).isEqualTo("_привет");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#firstLetterToUpperCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FirstLetterToUpperCase
	{
		/**
		 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}.
		 */
		@Test
		public void firstLetterToUpperCase()
		{
			String value = "привет";

			String actualString = Stringi.firstLetterToUpperCase(value);

			assertThat(actualString).isEqualTo("Привет");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} с пустым значением.
		 */
		@Test
		public void firstLetterToUpperCaseEmpty()
		{
			String value = "";

			String actualString = Stringi.firstLetterToUpperCase(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)}с одной буквой в значении.
		 */
		@Test
		public void firstLetterToUpperCaseOneChar()
		{
			String value = "п";

			String actualString = Stringi.firstLetterToUpperCase(value);

			assertThat(actualString).isEqualTo("П");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если первый символ значения не буква.
		 */
		@Test
		public void firstLetterToUpperCaseFirstNotChar()
		{
			String value = "_-привет";

			String actualString = Stringi.firstLetterToUpperCase(value);

			assertThat(actualString).isEqualTo("_-Привет");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToUpperCase(String)} если в значении нет букв.
		 */
		@Test
		public void firstLetterToUpperCaseNotChar()
		{
			String value = "_-/*-/-/*";

			String actualString = Stringi.firstLetterToUpperCase(value);

			assertThat(actualString).isEqualTo("_-/*-/-/*");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#firstLetterToLowerCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FirstLetterToLowerCase
	{
		/**
		 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}.
		 */
		@Test
		public void firstLetterToLowerCase()
		{
			String value = "ПРИВЕТ";

			String actualString = Stringi.firstLetterToLowerCase(value);

			assertThat(actualString).isEqualTo("пРИВЕТ");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} с пустым значением.
		 */
		@Test
		public void firstLetterToLowerCaseEmpty()
		{
			String value = "";

			String actualString = Stringi.firstLetterToLowerCase(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)}с одной буквой в значении.
		 */
		@Test
		public void firstLetterToLowerCaseOneChar()
		{
			String value = "П";

			String actualString = Stringi.firstLetterToLowerCase(value);

			assertThat(actualString).isEqualTo("п");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если первый символ значения не буква.
		 */
		@Test
		public void firstLetterToLowerCaseFirstNotChar()
		{
			String value = "_-ПРИВЕТ";

			String actualString = Stringi.firstLetterToLowerCase(value);

			assertThat(actualString).isEqualTo("_-пРИВЕТ");
		}

		/**
		 * Проверка метода {@link Stringi#firstLetterToLowerCase(String)} если в значении нет букв.
		 */
		@Test
		public void firstLetterToLowerCaseNotChar()
		{
			String value = "_-/*-/-/*";

			String actualString = Stringi.firstLetterToLowerCase(value);

			assertThat(actualString).isEqualTo("_-/*-/-/*");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchFirst(String, List)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchFirstList
	{
		/**
		 * Проверка метода {@link Stringi#searchFirst(String, List)}.
		 */
		@Test
		public void searchFirst()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchFirst(value, List.of('.'));

			assertThat(actualPosition).isEqualTo(46);
		}

		/**
		 * Проверка метода {@link Stringi#searchFirst(String, List)} с пустым списком.
		 */
		@Test
		public void searchFirstEmpty()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchFirst(value, List.of());

			assertThat(actualPosition).isNull();
		}

		/**
		 * Проверка метода {@link Stringi#searchFirst(String, List)} с первым искомым символом в строке.
		 */
		@Test
		public void searchFirstFirstLetter()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchFirst(value, List.of('М'));

			assertThat(actualPosition).isEqualTo(0);
		}

		/**
		 * Проверка метода {@link Stringi#searchFirst(String, List)} с несколькими искомыми символами.
		 */
		@Test
		public void searchFirstManyLetter()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchFirst(value, List.of('ж', ','));

			assertThat(actualPosition).isEqualTo(4);
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchFirst(String, char)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchFirstCharacter
	{
		/**
		 * Проверка метода {@link Stringi#searchFirst(String, char)}.
		 */
		@Test
		public void searchFirst()
		{
			String value = "Красно-жёлтые дни - песня группы Кино";

			Integer actualPosition = Stringi.searchFirst(value, '-');

			assertThat(actualPosition).isEqualTo(6);
		}

		/**
		 * Проверка метода {@link Stringi#searchFirst(String, char)} с отсутствием искомого символа.
		 */
		@Test
		public void searchFirstNotSymbols()
		{
			String value = "Красно-жёлтые дни - песня группы Кино";

			Integer actualPosition = Stringi.searchFirst(value, ':');

			assertThat(actualPosition).isNull();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchLast(String, List)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchLastList
	{
		/**
		 * Проверка метода {@link Stringi#searchLast(String, List)}.
		 */
		@Test
		public void searchLast()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchLast(value, List.of('.'));

			assertThat(actualPosition).isEqualTo(46);
		}

		/**
		 * Проверка метода {@link Stringi#searchLast(String, List)} с пустым списком.
		 */
		@Test
		public void searchLastEmpty()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchLast(value, List.of());

			assertThat(actualPosition).isNull();
		}

		/**
		 * Проверка метода {@link Stringi#searchLast(String, List)} с первым искомым символом в строке.
		 */
		@Test
		public void searchLastFirstLetter()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchLast(value, List.of('М'));

			assertThat(actualPosition).isEqualTo(0);
		}

		/**
		 * Проверка метода {@link Stringi#searchLast(String, List)} с несколькими искомыми символами.
		 */
		@Test
		public void searchLastManyLetter()
		{
			String value = "Мама, мы все тяжело больны - песня группы Кино.";

			Integer actualPosition = Stringi.searchLast(value, List.of('ж', ','));

			assertThat(actualPosition).isEqualTo(15);
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchLast(String, char)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchLastCharacter
	{
		/**
		 * Проверка метода {@link Stringi#searchLast(String, char)}.
		 */
		@Test
		public void searchLast()
		{
			String value = "Красно-жёлтые дни - песня группы Кино";

			Integer actualPosition = Stringi.searchLast(value, '-');

			assertThat(actualPosition).isEqualTo(18);
		}
		/**
		 * Проверка метода {@link Stringi#searchLast(String, char)} с отсутствием искомого символа.
		 */
		@Test
		public void searchLastNotSymbols()
		{
			String value = "Красно-жёлтые дни - песня группы Кино";

			Integer actualPosition = Stringi.searchLast(value, ':');

			assertThat(actualPosition).isNull();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#repeatToLength(String, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class RepeatToLength
	{
		/**
		 * Проверка метода {@link Stringi#repeatToLength(String, int)}.
		 */
		@Test
		public void repeatToLength()
		{
			String value = "Без десяти";

			String actualString = Stringi.repeatToLength(value, 15);

			assertThat(actualString).isEqualTo("Без десятиБез д");
		}

		/**
		 * Проверка метода {@link Stringi#repeatToLength(String, int)} с отрицательным значением.
		 */
		@Test
		public void repeatToLengthLengthNegative()
		{
			String value = "Без десяти";

			assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
				Stringi.repeatToLength(value, -1);
			});
		}

		/**
		 * Проверка метода {@link Stringi#repeatToLength(String, int)} с {@code null}.
		 */
		@Test
		public void repeatToLengthLengthZero()
		{
			String value = "Без десяти";

			String actualString = Stringi.repeatToLength(value, 0);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#shuffle(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Shuffle
	{
		/**
		 * Проверка метода {@link Stringi#shuffle(String)}.
		 */
		@Test
		public void shuffle()
		{
			String value = "Когда твоя девушка больна";

			String actualString = Stringi.shuffle(value);

			assertThat(actualString).isNotEqualTo("Когда твоя девушка больна");
		}

		/**
		 * Проверка метода {@link Stringi#shuffle(String)} с пустым значением.
		 */
		@Test
		public void shuffleEmpty()
		{
			String value = "";

			String actualString = Stringi.shuffle(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#shuffle(String)} по количеству символов в строке
		 * после перемешивания символов в строке.
		 */
		@Test
		public void shuffleEqualsLength()
		{
			String value = "Когда твоя девушка больна";

			String actualString = Stringi.shuffle(value);

			assertThat(actualString).hasSize("Когда твоя девушка больна".length());
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#reverse(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Reverse
	{
		/**
		 * Проверка метода {@link Stringi#reverse(String)}.
		 */
		@Test
		public void reverse()
		{
			String value = "Малыш";

			String actualString = Stringi.reverse(value);

			assertThat(actualString).isEqualTo("шылаМ");
		}

		/**
		 * Проверка метода {@link Stringi#reverse(String)} с пустым значением.
		 */
		@Test
		public void reverseEmpty()
		{
			String value = "";

			String actualString = Stringi.reverse(value);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#countVariousSymbols(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class CountVariousSymbols
	{
		/**
		 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
		 */
		@Test
		public void countVariousSymbols()
		{
			String value = "Я хочу быть кочегаром";

			int actualCount = Stringi.countVariousSymbols(value);

			assertThat(actualCount).isEqualTo(16);
		}

		/**
		 * Проверка метода {@link Stringi#countVariousSymbols(String)} с пустым значением.
		 */
		@Test
		public void countVariousSymbolsEmpty()
		{
			String value = "";

			int actualCount = Stringi.countVariousSymbols(value);

			assertThat(actualCount).isEqualTo(0);
		}

		/**
		 * Проверка метода {@link Stringi#countVariousSymbols(String)} с переносом строки.
		 */
		@Test
		public void countVariousSymbolsReturnLine()
		{
			String value = "Я хочу быть кочегаром\n";

			int actualCount = Stringi.countVariousSymbols(value);

			assertThat(actualCount).isEqualTo(17);
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#isPalindrome(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class IsPalindrome
	{
		/**
		 * Проверка метода {@link Stringi#isPalindrome(String)}.
		 */
		@Test
		public void isPalindrome()
		{
			String value = "ШАЛАШ";

			boolean actual = Stringi.isPalindrome(value);

			assertThat(actual).isTrue();
		}

		/**
		 * Проверка метода {@link Stringi#isPalindrome(String)} с некорректным значением.
		 */
		@Test
		public void isPalindromeNotCorrect()
		{
			String value = "МАЛЫШ";

			boolean actual = Stringi.isPalindrome(value);

			assertThat(actual).isFalse();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#isPalindromeIgnoreCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class IsPalindromeIgnoreCase
	{
		/**
		 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)}.
		 */
		@Test
		public void isPalindromeIgnoreCase()
		{
			String value = "Шалаш";

			boolean actual = Stringi.isPalindromeIgnoreCase(value);

			assertThat(actual).isTrue();
		}

		/**
		 * Проверка метода {@link Stringi#isPalindromeIgnoreCase(String)} с некорректным значением.
		 */
		@Test
		public void isPalindromeIgnoreCaseNotCorrect()
		{
			String value = "Малыш";

			boolean actual = Stringi.isPalindromeIgnoreCase(value);

			assertThat(actual).isFalse();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#join(List)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class JoinList
	{
		/**
		 * Проверка метода {@link Stringi#join(List)}.
		 */
		@Test
		public void join()
		{
			List<String> value = List.of("Белы", "й д", "ень");

			String actualString = Stringi.join(value);

			assertThat(actualString).isEqualTo("Белый день");
		}

		/**
		 * Проверка метода {@link Stringi#join(List)} со значением {@code null}.
		 */
		@Test
		public void joinNull()
		{
			List<String> values = new ArrayList<>();
			values.add("Белый");
			values.add(null);
			values.add("день");

			String actualString = Stringi.join(values);

			assertThat(actualString).isEqualTo("Белыйдень");
		}

		/**
		 * Проверка метода {@link Stringi#join(List)} без значений.
		 */
		@Test
		public void joinEmpty()
		{
			List<String> value = List.of();

			String actualString = Stringi.join(value);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#join(List, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class JoinListSeparator
	{
		/**
		 * Проверка метода {@link Stringi#join(List, String)}.
		 */
		@Test
		public void join()
		{
			List<String> value = List.of("Белы", "й д", "ень");

			String actualString = Stringi.join(value, "|");

			assertThat(actualString).isEqualTo("Белы|й д|ень");
		}

		/**
		 * Проверка метода {@link Stringi#join(List, String)} с пустым значением.
		 */
		@Test
		public void joinEmpty()
		{
			List<String> value = List.of();

			String actualString = Stringi.join(value, "|");

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#join(String[])}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class JoinArrayString
	{
		/**
		 * Проверка метода {@link Stringi#join(String[])}.
		 */
		@Test
		public void join()
		{
			String[] value = new String[]{"К", "И", "Н", "О"};

			String actualString = Stringi.join(value);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#join(String[])} со значением {@code null}.
		 */
		@Test
		public void joinNull()
		{
			String[] value = new String[] {"K", "I", null, "N", "O"};

			String actualString = Stringi.join(value);

			assertThat(actualString).isEqualTo("KINO");
		}

		/**
		 * Проверка метода {@link Stringi#join(String[])} без значений.
		 */
		@Test
		public void joinEmpty()
		{
			String[] value = new String[] {};

			String actualString = Stringi.join(value);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#join(String[], String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class JoinArraySeparator
	{
		/**
		 * Проверка метода {@link Stringi#join(String[], String)}.
		 */
		@Test
		public void join()
		{
			String[] value = new String[]{"К", "И", "Н", "О"};

			String actualString = Stringi.join(value, "|");

			assertThat(actualString).isEqualTo("К|И|Н|О");
		}

		/**
		 * Проверка метода {@link Stringi#join(String[], String)} с пустым значением.
		 */
		@Test
		public void joinEmpty()
		{
			String[] value = new String[]{};

			String actualString = Stringi.join(value, "|");

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#fillLeft(String, String, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FillLeft
	{
		/**
		 * Проверка метода {@link Stringi#fillLeft(String, String, int)}.
		 */
		@Test
		public void fillLeft()
		{
			String value = "КИНО";

			String actualString = Stringi.fillLeft(value, "#", 10);

			assertThat(actualString).isEqualTo("######КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fillLeft(String, String, int)} с {@code null}.
		 */
		@Test
		public void fillLeftLengthZero()
		{
			String value = "КИНО";

			String actualString = Stringi.fillLeft(value, "#", 0);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fillLeft(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillLeftFillerEmpty()
		{
			String value = "КИНО";

			String actualString = Stringi.fillLeft(value, "", 10);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fillLeft(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillLeftStringEmpty()
		{
			String value = "";

			String actualString = Stringi.fillLeft(value, "#", 10);

			assertThat(actualString).isEqualTo("##########");
		}

		/**
		 * Проверка метода {@link Stringi#fillLeft(String, String, int)} с отрицательным значением.
		 */
		@Test
		public void fillLeftLengthNegative()
		{
			String value = "КИНО";

			assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
				Stringi.fillLeft(value, "#", -1);
			});
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#fill(String, String, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Fill
	{
		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)}.
		 */
		@Test
		public void fill()
		{
			String value = "КИНО";

			String actualString = Stringi.fill(value, "#", 10);

			assertThat(actualString).isEqualTo("###КИНО###");
		}

		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)} с {@code null}.
		 */
		@Test
		public void fillLengthZero()
		{
			String value = "КИНО";

			String actualString = Stringi.fill(value, "#", 0);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillFillerEmpty()
		{
			String value = "КИНО";

			String actualString = Stringi.fill(value, "", 10);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillStringEmpty()
		{
			String value = "";

			String actualString = Stringi.fill(value, "#", 10);

			assertThat(actualString).isEqualTo("##########");
		}

		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)} с отрицательным значением.
		 */
		@Test
		public void fillLengthNegative()
		{
			String value = "КИНО";

			assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
				Stringi.fill(value, "#", -1);
			});
		}

		/**
		 * Проверка метода {@link Stringi#fill(String, String, int)} с нечётным значением.
		 */
		@Test
		public void fillLengthUneven()
		{
			String value = "КИНО";

			String actualString = Stringi.fill(value, "#", 9);

			assertThat(actualString).isEqualTo("##КИНО###");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#fillRight(String, String, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class FillRight
	{
		/**
		 * Проверка метода {@link Stringi#fillRight(String, String, int)}.
		 */
		@Test
		public void fillRight()
		{
			String value = "КИНО";

			String actualString = Stringi.fillRight(value, "#", 10);

			assertThat(actualString).isEqualTo("КИНО######");
		}

		/**
		 * Проверка метода {@link Stringi#fillRight(String, String, int)} с {@code null}.
		 */
		@Test
		public void fillRightLengthZero()
		{
			String value = "КИНО";

			String actualString = Stringi.fillRight(value, "#", 0);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fillRight(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillRightFillerEmpty()
		{
			String value = "КИНО";

			String actualString = Stringi.fillRight(value, "", 10);

			assertThat(actualString).isEqualTo("КИНО");
		}

		/**
		 * Проверка метода {@link Stringi#fillRight(String, String, int)} с пустым значением.
		 */
		@Test
		public void fillRightStringEmpty()
		{
			String value = "";

			String actualString = Stringi.fillRight(value, "#", 10);

			assertThat(actualString).isEqualTo("##########");
		}

		/**
		 * Проверка метода {@link Stringi#fillRight(String, String, int)} с отрицательным значением.
		 */
		@Test
		public void fillRightLengthNegative()
		{
			String value = "КИНО";

			assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
				Stringi.fillRight(value, "#", -1);
			});
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#trimLeft(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class TrimLeft
	{
		/**
		 * Проверка метода {@link Stringi#trimLeft(String)}}.
		 */
		@Test
		public void trimLeft()
		{
			String value = "\t \nВидели ночь\n \t";

			String actualString = Stringi.trimLeft(value);

			assertThat(actualString).isEqualTo("Видели ночь\n \t");
		}

		/**
		 * Проверка метода {@link Stringi#trimLeft(String)} с пустым значением.
		 */
		@Test
		public void trimLeftEmpty()
		{
			String value = "";

			String actualString = Stringi.trimLeft(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#trimLeft(String)} только с символами пустого пространства.
		 */
		@Test
		public void trimLeftAllWhitespace()
		{
			String value = "\t\n \t\r";

			String actualString = Stringi.trimLeft(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#trimLeft(String)} с отсутствием символов пустого пространства.
		 */
		@Test
		public void trimLeftNotWhitespace()
		{
			String value = "Видели ночь";

			String actualString = Stringi.trimLeft(value);

			assertThat(actualString).isEqualTo("Видели ночь");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#trimRight(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class TrimRight
	{
		/**
		 * Проверка метода {@link Stringi#trimRight(String)}}.
		 */
		@Test
		public void trimRight()
		{
			String value = "\t \nВидели ночь\n \t";

			String actualString = Stringi.trimRight(value);

			assertThat(actualString).isEqualTo("\t \nВидели ночь");
		}

		/**
		 * Проверка метода {@link Stringi#trimRight(String)} с пустым значением.
		 */
		@Test
		public void trimRightEmpty()
		{
			String value = "";

			String actualString = Stringi.trimRight(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#trimRight(String)} только с символами пустого пространства.
		 */
		@Test
		public void trimRightAllWhitespace()
		{
			String value = "\t\n \t\r";

			String actualString = Stringi.trimRight(value);

			assertThat(actualString).isEmpty();
		}

		/**
		 * Проверка метода {@link Stringi#trimRight(String)} с отсутствием символов пустого пространства.
		 */
		@Test
		public void trimRightNotWhitespace()
		{
			String value = "Видели ночь";

			String actualString = Stringi.trimRight(value);

			assertThat(actualString).isEqualTo("Видели ночь");
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#toCharList(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class ToCharList
	{
		/**
		 * Проверка метода {@link Stringi#toCharList(String)}.
		 */
		@Test
		public void toCharList()
		{
			String value = "Walk all over you";
			List<Character> expectedList = List.of(
				'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
			);

			List<Character> actualList = Stringi.toCharList(value);

			assertThat(actualList).containsSequence(expectedList);
		}

		/**
		 * Проверка метода {@link Stringi#toCharList(String)}.
		 */
		@Test
		public void toCharListEmpty()
		{
			String value = "";
			List<Character> expectedList = List.of();

			List<Character> actualList = Stringi.toCharList(value);

			assertThat(actualList).containsSequence(expectedList);
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#toCharArray(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class ToCharArray
	{
		/**
		 * Проверка метода {@link Stringi#toCharArray(String)}.
		 */
		@Test
		public void toCharArray()
		{
			String value = "Walk all over you";
			Character[] expectedArray = {
				'W', 'a', 'l', 'k', ' ', 'a', 'l', 'l', ' ', 'o', 'v', 'e', 'r', ' ', 'y', 'o', 'u'
			};

			Character[] actualArray = Stringi.toCharArray(value);

			assertThat(actualArray).containsSequence(expectedArray);
		}

		/**
		 * Проверка метода {@link Stringi#toCharArray(String)} с пустым значением.
		 */
		@Test
		public void toCharArrayEmpty()
		{
			String value = "";
			Character[] expectedArray = {};

			Character[] actualArray = Stringi.toCharArray(value);

			assertThat(actualArray).containsSequence(expectedArray);
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#glue(List)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GlueList
	{
		/**
		 * Проверка метода {@link Stringi#glue(List)}.
		 */
		@Test
		public void glue()
		{
			List<Character> value = List.of('A', 'C', '/', 'D', 'C');

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEqualTo("AC/DC");
		}

		/**
		 * Проверка метода {@link Stringi#glue(List)} со значением {@code null}.
		 */
		@Test
		public void glueNull()
		{
			List<Character> value = new ArrayList<>();
			value.add('A');
			value.add('C');
			value.add(null);
			value.add('D');
			value.add('C');

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEqualTo("ACDC");
		}

		/**
		 * Проверка метода {@link Stringi#glue(List)} без значений.
		 */
		@Test
		public void glueEmpty()
		{
			List<Character> value = List.of();

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#glue(List, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GlueListSeparator
	{
		/**
		 * Проверка метода {@link Stringi#glue(List, String)}.
		 */
		@Test
		public void glue()
		{
			List<Character> value = List.of('T', 'N', 'T');

			String actualString = Stringi.glue(value, ".");

			assertThat(actualString).isEqualTo("T.N.T");
		}

		/**
		 * Проверка метода {@link Stringi#glue(List, String)} с пустым значением.
		 */
		@Test
		public void glueEmpty()
		{
			List<Character> value = List.of();

			String actualString = Stringi.glue(value, ".");

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#glue(Character[])}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GlueArrayCharacter
	{
		/**
		 * Проверка метода {@link Stringi#glue(Character[])}.
		 */
		@Test
		public void glue()
		{
			Character[] value = new Character[]{'A', 'C', '/', 'D', 'C'};

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEqualTo("AC/DC");
		}

		/**
		 * Проверка метода {@link Stringi#glue(Character[])} со значением {@code null}.
		 */
		@Test
		public void glueNull()
		{
			Character[] value = new Character[] {'T', null, 'N', 'T'};

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEqualTo("TNT");
		}

		/**
		 * Проверка метода {@link Stringi#glue(Character[])} с пустым массивом.
		 */
		@Test
		public void glueEmpty()
		{
			Character[] value = new Character[] {};

			String actualString = Stringi.glue(value);

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#glue(Character[], String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GlueArraySeparator
	{
		/**
		 * Проверка метода {@link Stringi#glue(Character[], String)}.
		 */
		@Test
		public void glue()
		{
			Character[] value = new Character[]{'T', 'N', 'T'};

			String actualString = Stringi.glue(value, ".");

			assertThat(actualString).isEqualTo("T.N.T");
		}

		/**
		 * Проверка метода {@link Stringi#glue(Character[], String)} с пустым значением.
		 */
		@Test
		public void glueEmpty()
		{
			Character[] value = new Character[]{};

			String actualString = Stringi.glue(value, ".");

			assertThat(actualString).isEmpty();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchFirstLetter(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchFirstLetter
	{
		/**
		 * Проверка метода {@link Stringi#searchFirstLetter(String)}.
		 */
		@Test
		public void searchFirstLetter()
		{
			String value = "+Когда твоя девушка больна+";

			Integer actualPosition = Stringi.searchFirstLetter(value);

			assertThat(actualPosition).isEqualTo(1);
		}

		/**
		 * Проверка метода {@link Stringi#searchFirstLetter(String)} с отсутствием букв.
		 */
		@Test
		public void searchFirstLetterNotLetter()
		{
			String value = "+++++++++++++";

			Integer actualPosition = Stringi.searchFirstLetter(value);

			assertThat(actualPosition).isNull();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#searchLastLetter(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class SearchLastLetter
	{
		/**
		 * Проверка метода {@link Stringi#searchLastLetter(String)}.
		 */
		@Test
		public void searchLastLetter()
		{
			String value = "###Ночь###";

			Integer actualPosition = Stringi.searchLastLetter(value);

			assertThat(actualPosition).isEqualTo(6);
		}

		/**
		 * Проверка метода {@link Stringi#searchLastLetter(String)} с отсутствием букв.
		 */
		@Test
		public void searchLastLetterNotLetter()
		{
			String value = "##############";

			Integer actualPosition = Stringi.searchLastLetter(value);

			assertThat(actualPosition).isNull();
		}
	}

	/**
	 * Класс проверки метода {@link Stringi#reverseCase(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class ReverseCase
	{
		/**
		 * Проверка метода {@link Stringi#reverseCase(String)}.
		 */
		@Test
		public void reverseCase()
		{
			String value = "пРиВеТ";

			String actualString = Stringi.reverseCase(value);

			assertThat(actualString).isEqualTo("ПрИвЕт");
		}

		/**
		 * Проверка метода {@link Stringi#reverseCase(String)} с отсутствием букв.
		 */
		@Test
		public void reverseCaseNotLetter()
		{
			String value = "56776843245";

			String actualString = Stringi.reverseCase(value);

			assertThat(actualString).isEqualTo("56776843245");
		}
	}
}