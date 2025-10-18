package go_utils

import (
	"container/heap"
)

type HeapType int

const (
	MinHeap HeapType = iota
	MaxHeap
)

type Item struct {
	Value    any
	Priority int
	index    int
}

type PriorityQueue struct {
	items    []*Item
	heapType HeapType
}

func (pq PriorityQueue) Len() int { return len(pq.items) }

func (pq PriorityQueue) Less(i, j int) bool {
	if pq.heapType == MinHeap {
		if pq.items[i].Priority == pq.items[j].Priority {
			return pq.items[i].Value.(int) < pq.items[j].Value.(int)
		}
		return pq.items[i].Priority < pq.items[j].Priority
	} else { // MaxHeap
		if pq.items[i].Priority == pq.items[j].Priority {
			return pq.items[i].Value.(int) < pq.items[j].Value.(int)
		}
		return pq.items[i].Priority > pq.items[j].Priority
	}
}

func (pq PriorityQueue) Swap(i, j int) {
	pq.items[i], pq.items[j] = pq.items[j], pq.items[i]
	pq.items[i].index = i
	pq.items[j].index = j
}

func (pq *PriorityQueue) Push(x any) {
	n := len(pq.items)
	item := x.(*Item)
	item.index = n
	pq.items = append(pq.items, item)
}

func (pq *PriorityQueue) Pop() any {
	old := pq.items
	n := len(old)
	item := old[n-1]
	pq.items = old[0 : n-1]
	return item
}

func NewPriorityQueue(heapType HeapType) *PriorityQueue {
	pq := &PriorityQueue{
		items:    make([]*Item, 0),
		heapType: heapType,
	}
	heap.Init(pq)
	return pq
}

func (pq *PriorityQueue) PushItem(value any, priority int) {
	heap.Push(pq, &Item{Value: value, Priority: priority})
}

func (pq *PriorityQueue) PopItem() *Item {
	if pq.Len() == 0 {
		return nil
	}
	return heap.Pop(pq).(*Item)
}
