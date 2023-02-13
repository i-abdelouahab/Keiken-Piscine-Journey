	
#### Using the find command, find and list the names of:
- all files under the /etc directory whose names begin with rc:


Use the command:

```
find /etc -name 'rc*'
```
In te output we can see the files that are directory in /etc and others that are in subdirectories of /etc. 

- all regular files belonging to you; put the result in the file /tmp/findme and errors in/dev/null,

You can use the command ``find ~ -type f -user $USER`` to find all files that belongs to you as shown as follows:
```
find ~ -type f -user $USER > /tmp/findme 2> /dev/null
```
> `` /tmp/findme`` to set results in the file findme of the temp directory.
> `` 2> /dev/null``, the number 2 is used to redirect the output of the stderr stream to /dev/null
> for example if we have a command like ``command_line 2> output_errors_file`` that will redirects any error produced by ``command_line`` to the ``output_errors_file`` file.

- all subdirectories of /etc,

It can be done with the command:
```
find /etc -type d
```

- all regular files under your home directory that have not been modified in the last 10 days

> We use find with the argument -type f to get only files uder the home directory, the argument >``-mtime -N`` is used to match files that had their data modified in the last N days (in our case 10). the -ls argument is added to see all details of those files. 

```
find ~/ -type f -mtime -10 -ls
```

- The 10 largest file in your computer

To display the 10 more largest files under the root directory, let use the following command line (here we must add sudo to grant privileges for some files):

```
sudo find / -printf '%s%p\n'| sort -nr | head -10
```