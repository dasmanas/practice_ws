# Red-Black Tree

## Basics

1. A node is either Red or Black
2. Root node and leaf nodes are Black
3. If a node is Red, then its children are Black.
4. All paths from a node to its NIL descendants contain the same number of Black nodes.

```
                 B  <-- Grand Parent of X
                / \
Uncle of X --> C   A  <-- Parent of X
                  /
                 X
```     

## Insert Strategy

1. Insert node X and color it to Red.
2. Recolor and rotate nodes to fix violations

There can 4 scenarios for point #2

1. X = root ==> Color it to Black
2. X.uncle = Red ==> Recolor Parent, Grand Parent & Uncle 
3. X.uncle = Black (triangle) ==> 

   B (black)
  / \
 C   A (red)
    /
   Z (red)
4. X.uncle = Black (line)



 


