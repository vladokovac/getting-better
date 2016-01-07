#include <iostream>
#include <string>

void reverse(char* str);

int main()
{
    char* string = "The quick brown fox jumps over the lazy dog";
    reverse(string);
    std::cout << string << std::endl;
}

void reverse(char* str)
{
    int stringSize = 0;

    /* If str is NULL or empty, do nothing */
    if( str == NULL || !(*str) )
      return;
    char currentChar = *(str);
    while (currentChar)
    {
        stringSize++;
        currentChar = *(str + stringSize);
    }
    
    char newString[stringSize + 1];
    newString[stringSize] = '\0';
    char *end_ptr = str + stringSize - 1;
    int i = 0;
    while (i < stringSize) 
    {
        newString[i] = *(end_ptr - i);
        i++;
    }
    
    std::cout << newString << std::endl;
    
    *str = newString[0];
}