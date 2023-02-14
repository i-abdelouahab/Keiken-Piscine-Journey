#### Give the AWK script that displays the word frequency of a text.

```
awk '{
    for(i=1;i<=NF;i++){
        words[$i]++;
    }
}
END{
    printf "%-15s %s\n", "Word", "Frequency";
    for(word in words){
        printf "%-15s %d\n", word, words[word];
    }
}' sample.txt
```

#### Create an AWK script that show the number of repetition of a specific string in a list of strings then inverse it.

```
Still thinking for the solution
```

#### Use sed to extract full user names from /etc/passwd/

```
sed 's/^[^:]*:[^:]*:[^:]*:[^:]*:\([^:]*\).*$/\1/' /etc/passwd
```

#### Given a list of telephone numbers of the form 123456789 use sed to rewrite them as (123)456-789.

```
sed 's/\([0-9]\{3\}\)\([0-9]\{3\}\)\([0-9]\{3\}\)/(\1)\2-\3/g' contacts
```

#### Use sed to select and convert all file names with suffix .html given as output by ls into capital letters with suffix .HTM.

```
ls *.html | sed -e 's/\.html$/.HTM/'
```