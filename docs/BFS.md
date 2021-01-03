> 来自《labuladong的算法小抄》

# BFS算法

广度优先搜索算法

其实是一种寻找两点之间最短路径的问题。

# CodeTemplate

```
int bfs(Node start, Node target){
    // 核心数据结构
    Queue<Node> q;
    // 走过的路径记录，防止走回头路
    Set<Node> visited;
    q.offer(start);
    visited.add(start);
    int result = 0;
    while(!q.isEmpty()){
        int size = q.size();
        if(cur is target){
          return result;
        }
        for(int i=0;i<size;i++){
          Node cur = p.poll();
          cur = cur.someAdjust();
          if(cur not in visited){
            p.offer(cur);
            visited.offer(cur);
          }
        }
        // 更新步数
        result++;
    }
}
```

[二叉树最小高度](../src/com/hanelalo/bfs/MinWayOfBinaryTree.java)

[最少次数解锁](../src/com/hanelalo/bfs/UnLock.java)
