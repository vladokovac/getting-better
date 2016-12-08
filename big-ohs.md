# A list of Big Oh problems and answers

## Questions

1.

    for(int i = 0; i < n; i++)
        sum++;
    
2.

    for(int i = 0; i < n; i+=2)
        sum++;
    
3.

    for(int i = 0; i < n; i++)
        for( int j = 0; j < n; j++)
            sum++;
    
4.

    for(int i = 0; i < n; i+=2)
        sum++;
    for(int j = 0; j < n; j++)
        sum++;
    
5.

    for(int i = 0; i < n; i++)
        for( int j = 0; j < n * n; j++)
            sum++;
    
6.

    for(int i = 0; i < n; i++)
        for( int j = 0; j < i; j++)
            sum++;
    
7.

    for(int i = 0; i < n; i++)
        for( int j = 0; j < n * n; j++)
            for(int k = 0; k < j; k++)
                sum++;

8.

    for(int i = 1; i < n; i = i * 2)
        sum++;
        
9.

    for i = 1 to n do
        j = i
        while j < n do
            j = j + 3
        
10.

    for i = 1 to n do
        for j = 2*i to n do
            s = s+1

11.

    for i = 1 to n do
        j = i
        while j < n do
            j = 2*j

12.

    for i = 1 to n do
        j = n
        while i*i < j do
            j = j - 1
            
13.

    for i = 1 to n do
        j = 2
        while j < i do
            j = j*j









## Answers

1. `O(n)`
2. `O(n)`
3. `O(n^2)`
4. `O(n)`
5. `O(n^3)`
6. `O(n^2)`
7. `O(n^5)`
8. `O(log(n))`
9. `O(n^2)`
10. `O(n^2)`
11. `O(nlog(n))`
12. `O(n sqrt(n))`
13. `O(nlg(n))`

