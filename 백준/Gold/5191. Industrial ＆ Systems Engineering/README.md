# [Gold V] Industrial & Systems Engineering - 5191 

[문제 링크](https://www.acmicpc.net/problem/5191) 

### 성능 요약

메모리: 31100 KB, 시간: 2296 ms

### 분류

그리디 알고리즘, 브루트포스 알고리즘, 기하학, 피타고라스 정리

### 제출 일자

2025년 8월 14일 07:14:23

### 문제 설명

<p>A lot of what industrial engineering does is plan and improve industrial processes to be more efficient. As such, they solve a lot of optimization problems in product planning, supply management, etc. Some of these are fairly complex, but a natural and clean version of one of the central topics can be understood quite easily.</p>

<p>In the “Warehouse Location Planning Problem”, you have several stores which need a supply of wares. In order to provide them with the wares, you can build several warehouses. For each warehouse, there is a price to build it (depending on where it is located). On the other hand, if a store is far from its assigned warehouse, it is expensive to ship all the goods to it. So the warehouse locations need to trade off between building costs and shipping costs. The goal is then to build warehouses to minimize the cost.</p>

<p>We assume that if the locations of a warehouse and a store are given, the shipping cost is exactly equal to their Euclidian distance. We also assume that any warehouse, once built, can supply arbitrarily many stores. Notice that you must always build at least one warehouse. The total cost is then the sum of the building costs, plus the sum of shipping costs for all stores from their assigned warehouse.</p>

### 입력 

 <p>The first line contains a number K ≥ 1, which is the number of input data sets in the file. This is followed by K data sets of the following form:</p>

<p>The first line of a data set contains two numbers n, m, the number of stores, and the number of possible warehouse locations under consideration. The number of stores will be between 1 and 100, and the number of warehouse locations between 1 and 20.</p>

<p>This is followed by n lines, each describing a store, by giving its x and y coordinates (floating point numbers).</p>

<p>Next are m lines, each describing a warehouse location and price as floating point numbers x, y, p. Here, p will be non-negative.</p>

### 출력 

 <p>For each data set, first output “Data Set x:” on a line by itself, where x is its number. Then, output the minimum total cost at which all stores can be supplied, rounded to two decimals.</p>

