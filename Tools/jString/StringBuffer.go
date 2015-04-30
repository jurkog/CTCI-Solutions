package jString

type StringBuffer struct {
	buffer []byte
}

func (sb *StringBuffer) Append(s string) {
	sb.buffer = append(sb.buffer, []byte(s)...)
}

func (sb *StringBuffer) AppendByte(b byte) {
	sb.buffer = append(sb.buffer, b)
}

func (sb *StringBuffer) AppendBytes(b []byte) {
	sb.buffer = append(sb.buffer, b...)
}

func (sb *StringBuffer) ToString() string {
	return string(sb.buffer)
}

func NewBuffer() *StringBuffer{
	return &StringBuffer{}
}
