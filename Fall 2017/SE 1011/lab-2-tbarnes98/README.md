# Lab 2: Keeping Our Sources Straight
## Objectives
- Translate UML class diagrams into source code
- Construct software which uses class inheritance
- Employ method Overriding in the development of software
- Use the super keyword to execute constructors in a superclass
- Use the java.util.ArrayList collection class to hold class data

## Introduction
When writing a research paper, it is very important to keep your sources straight. You will discover this in your GS-1002 course, where you will learn about formal research papers. You will also use this skill later on in your academic career here at MSOE.

BibTeX is reference management software for formatting lists of references, and is very commonly used in engineering research papers at the graduate level. The BibTeX tool is typically used together with the LaTeX document preparation system, allowing one to easily manage bibliography entries and a formal paper. BibTeX makes it easy to cite sources in a consistent manner, by separating bibliographic information from the presentation of this information.

For example, we might use a book as a reference. An appropriate book entry is that which is shown below. Note that the syntax for this format is very important, so pay attention to all the commas, braces, quotes, etc…
```
@BOOK { SE1021Text,
author = "John Dean and Raymond Dean", 
title = "Introduction to Programming with Java",
publisher = "McGraw Hill",
year = "2014"
}
```
An article, published in a magazine, might be referenced in the format shown below.
```
@ARTICLE { WSMA2006,
author = "Walter Schilling and Dr. Mansoor Alam", 
title = "Integrate static analysis into a software development process",
journal = "Embedded Systems Design",
pages = "67-72",
year = "2006"
}
```

Note that the unique identifiers in these two examples (SE1021Text and WSMA2006) were hand chosen. For your code, you will create them in an automated way where the first is REF0, then REF1, then REF2, and so on (see sample output below).

In this lab, you are going to create a system which will allow the user to enter the fields for a given set of references and then be able to print out the bibtex entries for the entered references. You will be provided with a Main class, but are responsible for developing all other code for this project. [Javadoc updated 12/3/17](http://msoe.us/taylor/se1021/lab2doc/index.html) is available for each method. Be sure to read the complete Javadoc cafefully to ensure that your implementation of each method meets the specifications provided in the Javadoc. Note that when you update a reference, you can assume that the user will need to update the entire entry, not just the one component of the entry.

![Class diagram](http://msoe.us/taylor/se1021/lab2.png)

## Sample Program Execution
```
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
1
Enter the author of the book
John Will
Enter the title of the book
Star Wars
Enter the publisher for the book.
20th Century Fox
Enter the copyright year for the book.
1980
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
2
Enter the author of the article
Carl Sagan
Enter the title of the article
A Celebration of Isaac Asimov: A Man for the Universe
Enter the title of the journal.
The Skeptical Inquirer
Enter the first page of the article.
5
Enter the last page of the article.
7
Enter the copyright year for the article.
1992
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
4
@BOOK { REF0,
author = "John Will",
title = "Star Wars",
publisher = "20th Century Fox",
year = "1980"
}
@ARTICLE { REF1,
author = "Carl Sagan",
title = "A Celebration of Isaac Asimov: A Man for the Universe",
journal = "The Skeptical Inquirer",
pages = "5-7",
year = "1992"
}
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
3
Enter the ID of the reference you want to update
REF0
Enter the updated author of the reference
John Williams
Enter the updated title of the reference
Star Wars: The Musical Score
Enter the updated copyright year for the reference.
1977
Enter the updated publisher for the book
20th Century Fox
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
4
@BOOK { REF0,
author = "John Williams",
title = "Star Wars: The Musical Score",
publisher = "20th Century Fox",
year = "1977"
}
@ARTICLE { REF1,
author = "Carl Sagan",
title = "A Celebration of Isaac Asimov: A Man for the Universe",
journal = "The Skeptical Inquirer",
pages = "5-7",
year = "1992"
}
Enter 0 to exit the program.
Enter 1 to enter a new book into the reference set.
Enter 2 to enter a new article into the reference set.
Enter 3 to update a reference.
Enter 4 to printout the entries in Bibtex format.
0

```
