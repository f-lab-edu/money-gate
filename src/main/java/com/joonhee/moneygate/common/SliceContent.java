package com.joonhee.moneygate.common;

import java.util.List;

public record SliceContent<T>(List<T> content, String nextCursor) {
}