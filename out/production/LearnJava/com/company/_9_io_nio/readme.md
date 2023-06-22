** 1
Stream - это упорядоченная последовательность данных
Файлы - text files or binary files

** 10 
Buffer - Это блок памяти в который мы можем записывать информацию, а также читать ее
В отличеи от стиримов Channel работает в обе направление read-write

                    ->
Program <--> Buffer    Channel <--> File
                    <-

Buffer - position, limit, capacity
flip(), clear()