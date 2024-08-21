# Jumper
A simple URL shortening system.

## Algorithm
To make URLs as short as possible, several methods are used:
- **Using an auto-increment sequence**  
  This approach uses base 62 (0-9, a-z, A-Z), which gives 62^7 = 352,161,460,620,862 possible combinations, making 7 characters sufficient. The algorithm generates an auto-increment sequence, converts it to base 62, and maps it to a string. In a distributed system, different machines can generate sequences that don’t overlap (e.g., one machine generates odd numbers, and the other generates even numbers), as strict sequential order is unnecessary.
  
- **Hashing**  
  The long URL is hashed with MD5 to create a 32-character signature string, which is divided into four segments, each containing 8 characters. Each segment is processed by taking 8 characters, treating it as a hexadecimal string, and performing a bitwise AND operation with 0x3fffffff (30 bits). The resulting 30 bits are divided into 6 segments, with each 5-bit number used as an index to a character in the alphabet, resulting in a 6-character string. The MD5 string can generate four such 6-character strings, and any of them can be used as the short URL. The advantage of this method is the randomness and fixed length of the output string, though there is a very small possibility of hash collisions.

## One-to-One or One-to-Many?
The advantage of one-to-one mapping is that the same URL will always generate the same short URL. The downside is that it requires an additional mapping, which can be space-inefficient. If one-to-one mapping is necessary, you could cache frequently used long URLs and use LRU (Least Recently Used) for eviction. One-to-many mapping is simpler and more convenient.

## 301 or 302?
Returning a 301 (permanent redirect) is more appropriate for this use case, but returning a 302 (temporary redirect) has the added benefit of allowing you to track and analyze click rates and IP addresses.

## Preventing Attacks
A simple rate-limiting mechanism is implemented using Google’s Guava library's `RateLimiter` and Spring AOP.

## Screenshots

![](screenshots/ss0.png)  
![](screenshots/ss1.png)
