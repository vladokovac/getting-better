# A list of Big Oh problems and answers

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
