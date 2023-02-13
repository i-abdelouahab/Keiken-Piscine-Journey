
#### How is permission granted to delete a file?
> Files and directories are controlled by the file's access control list (ACL) and ownership. Every file has an owner that can grant file's permission for different types of users (group, others) and to delete a file the user must have the write permission on the parent directory and on the file itself, to grant permission of write we use chmod command, or the user may need to use system privileges.

#### Create a file that your colleague can edit but not delete and another he can delete but not edit
`> touch myFile`
`> chmod o+trw myFile` -- for the user 1
`> chmod o+tw myFile` -- for the user 2
> "o+trw" sets the permissions for "other" users (i.e., users who are not the owner of the file and not in the same group as the owner) to "t" (sticky bit), "r" (read), and "w" (write).

It doesn't make sense, if I could write in a file I can change all the content and there is no different between this and deleting the file itself, also when I can delete a file even if I don't the write permission the file is not secured.