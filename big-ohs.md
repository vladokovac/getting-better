# A list of Big Oh problems and answers

1. 
```
for(int i = 0; i < n; i++)
    sum++;
```   

2. 
```
for(int i = 0; i < n; i+=2)
    sum++;
O(N) for fragment 2 as well
```

3.
for(int i = 0; i < n; i++)
    for( int j = 0; j < n; j++)
        sum++;
O(N^2) for fragment 3

//Fragment 4
for(int i = 0; i < n; i+=2)
    sum++;
for(int j = 0; j < n; j++)
    sum++;
O(N) for fragment 4

//Fragment 5
for(int i = 0; i < n; i++)
    for( int j = 0; j < n * n; j++)
        sum++;
O(N^2) for fragment 5 but the n * n is throwing me off a bit so I'm not quite sure

//Fragment 6
for(int i = 0; i < n; i++)
    for( int j = 0; j < i; j++)
        sum++;
O(N^2) for fragment 6 as well

//Fragment 7
for(int i = 0; i < n; i++)
    for( int j = 0; j < n * n; j++)
        for(int k = 0; k < j; k++)
            sum++;
O(N^3) for fragment 7 but once again the n * n is throwing me off

//Fragment 8
for(int i = 1; i < n; i = i * 2)
    sum++;
