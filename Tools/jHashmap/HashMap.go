package jHashmap

const MAP_LENGTH = 16

type HashEntry struct {
	key string
	value string
	next *HashEntry
	hash int
}

type List struct {
	root, tail *HashEntry
	length int
}

type HashMap struct {
	entries [MAP_LENGTH]List
}
/* HashMap functions*/
func NewMap() *HashMap {
	return &HashMap{}
}

func (h *HashMap) Put(k, v string) {
	entry := &HashEntry{k, v, nil, hashCode(k)}
	h.inputEntry(entry)
}

func (h *HashMap) GetEntry(i int) *HashEntry {
	return h.entries[i].root
}

func (h *HashMap) Get(k string) string {
	index := hashCode(k) % MAP_LENGTH
	current := h.GetEntry(index)
	for current != nil {
		if current.key == k {
			return current.value
		}
		current = current.next
	}
	return "NULL"
}

func (h *HashMap) Delete(k string) {
	index := hashCode(k) % MAP_LENGTH
	current := h.GetEntry(index)
	// Empty list
	if current == nil {
		return
	}
	// If root is the node to be deleted
	if current.key == k {
		h.entries[index].root = current.next 
		current = nil
		return
	}
	for current.next != nil {
		if current.next.key == k {
			// Tail is not the node being deleted
			if current.next.next != nil {
				remainder := current.next.next
				current.next = nil
				current.next = remainder
				return
			} else {
				// Tail is being deleted
				current.next = nil
				h.entries[index].tail = current
				return
			}
		}
		current = current.next
	}
	
}

/* HashEntry functions */
func (e *HashEntry) GetKey() string{
	return e.key
}

func (e *HashEntry) GetValue() string{
	return e.value
}

func (e *HashEntry) Next() *HashEntry {
	return e.next
}

/* Methods that are not being exported */
func (h *HashMap) inputEntry(entry *HashEntry) {
	pos := entry.hash % MAP_LENGTH
	
	if h.entries[pos].root == nil {
		h.entries[pos].root = entry;
	} else {
		h.entries[pos].tail.next = entry;
	}
	h.entries[pos].tail = entry;
	h.entries[pos].length++
}


// This function creates the hashcode for every key that is inputted.
// It's my first attempt implementing a hashmap so my hashcode is determined
// on length of input.
// ie. len(k) = 6, then hashcode = 6 + 3 + 1 + 0 = 10
// ie. len(k) = 12, then hashcode = 12 + 6 + 3 + 1 + 0 = 22
func hashCode(k string) int{
	a, b := len(k), len(k)
	for a > 0 {
		b += a / 2
		a/=2
	}
	return b
}

